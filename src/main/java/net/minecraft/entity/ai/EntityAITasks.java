/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.profiler.Profiler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityAITasks {
    private static final Logger logger = LogManager.getLogger();
    private List<EntityAITaskEntry> taskEntries = Lists.newArrayList();
    private List<EntityAITaskEntry> executingTaskEntries = Lists.newArrayList();
    private final Profiler theProfiler;
    private int tickCount;
    private int tickRate = 3;

    public EntityAITasks(Profiler profiler) {
        this.theProfiler = profiler;
    }

    public void addTask(int n, EntityAIBase entityAIBase) {
        this.taskEntries.add(new EntityAITaskEntry(n, entityAIBase));
    }

    public void removeTask(EntityAIBase entityAIBase) {
        Iterator<EntityAITaskEntry> iterator2 = this.taskEntries.iterator();
        while (iterator2.hasNext()) {
            EntityAITaskEntry entityAITaskEntry = iterator2.next();
            EntityAIBase entityAIBase2 = entityAITaskEntry.action;
            if (entityAIBase2 != entityAIBase) continue;
            if (this.executingTaskEntries.contains(entityAITaskEntry)) {
                entityAIBase2.resetTask();
                this.executingTaskEntries.remove(entityAITaskEntry);
            }
            iterator2.remove();
        }
    }

    public void onUpdateTasks() {
        this.theProfiler.startSection("goalSetup");
        if (this.tickCount++ % this.tickRate == 0) {
            for (EntityAITaskEntry entityAITaskEntry : this.taskEntries) {
                boolean bl = this.executingTaskEntries.contains(entityAITaskEntry);
                if (bl) {
                    if (this.canUse(entityAITaskEntry) && this.canContinue(entityAITaskEntry)) continue;
                    entityAITaskEntry.action.resetTask();
                    this.executingTaskEntries.remove(entityAITaskEntry);
                }
                if (!this.canUse(entityAITaskEntry) || !entityAITaskEntry.action.shouldExecute()) continue;
                entityAITaskEntry.action.startExecuting();
                this.executingTaskEntries.add(entityAITaskEntry);
            }
        } else {
            Iterator<EntityAITaskEntry> iterator2 = this.executingTaskEntries.iterator();
            while (iterator2.hasNext()) {
                EntityAITaskEntry entityAITaskEntry;
                entityAITaskEntry = iterator2.next();
                if (this.canContinue(entityAITaskEntry)) continue;
                entityAITaskEntry.action.resetTask();
                iterator2.remove();
            }
        }
        this.theProfiler.endSection();
        this.theProfiler.startSection("goalTick");
        for (EntityAITaskEntry entityAITaskEntry : this.executingTaskEntries) {
            entityAITaskEntry.action.updateTask();
        }
        this.theProfiler.endSection();
    }

    private boolean canContinue(EntityAITaskEntry entityAITaskEntry) {
        boolean bl = entityAITaskEntry.action.continueExecuting();
        return bl;
    }

    private boolean canUse(EntityAITaskEntry entityAITaskEntry) {
        for (EntityAITaskEntry entityAITaskEntry2 : this.taskEntries) {
            if (entityAITaskEntry2 == entityAITaskEntry || !(entityAITaskEntry.priority >= entityAITaskEntry2.priority ? !this.areTasksCompatible(entityAITaskEntry, entityAITaskEntry2) && this.executingTaskEntries.contains(entityAITaskEntry2) : !entityAITaskEntry2.action.isInterruptible() && this.executingTaskEntries.contains(entityAITaskEntry2))) continue;
            return false;
        }
        return true;
    }

    private boolean areTasksCompatible(EntityAITaskEntry entityAITaskEntry, EntityAITaskEntry entityAITaskEntry2) {
        return (entityAITaskEntry.action.getMutexBits() & entityAITaskEntry2.action.getMutexBits()) == 0;
    }

    public class EntityAITaskEntry {
        public EntityAIBase action;
        public int priority;

        public EntityAITaskEntry(int n, EntityAIBase entityAIBase) {
            this.priority = n;
            this.action = entityAIBase;
        }
    }
}

