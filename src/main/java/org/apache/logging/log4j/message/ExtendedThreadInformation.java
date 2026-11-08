package org.apache.logging.log4j.message;

import java.lang.management.*;

public class ExtendedThreadInformation implements ThreadInformation
{
    private final ThreadInfo info;
    
    public ExtendedThreadInformation(final ThreadInfo info) {
        this.info = info;
    }
    
    @Override
    public void printThreadInfo(final StringBuilder sb) {
        sb.append("\"").append(this.info.getThreadName()).append("\"");
        sb.append(" Id=").append(this.info.getThreadId()).append(" ");
        this.formatState(sb, this.info);
        if (this.info.isSuspended()) {
            sb.append(" (suspended)");
        }
        if (this.info.isInNative()) {
            sb.append(" (in native)");
        }
        sb.append('\n');
    }
    
    @Override
    public void printStack(final StringBuilder sb, final StackTraceElement[] array) {
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            sb.append("\tat ").append(array[i].toString());
            sb.append('\n');
            if (n == 0 && this.info.getLockInfo() != null) {
                switch (this.info.getThreadState()) {
                    case BLOCKED: {
                        sb.append("\t-  blocked on ");
                        this.formatLock(sb, this.info.getLockInfo());
                        sb.append('\n');
                        break;
                    }
                    case WAITING: {
                        sb.append("\t-  waiting on ");
                        this.formatLock(sb, this.info.getLockInfo());
                        sb.append('\n');
                        break;
                    }
                    case TIMED_WAITING: {
                        sb.append("\t-  waiting on ");
                        this.formatLock(sb, this.info.getLockInfo());
                        sb.append('\n');
                        break;
                    }
                }
            }
            for (final MonitorInfo monitorInfo : this.info.getLockedMonitors()) {
                if (monitorInfo.getLockedStackDepth() == n) {
                    sb.append("\t-  locked ");
                    this.formatLock(sb, monitorInfo);
                    sb.append('\n');
                }
            }
            ++n;
        }
        final LockInfo[] lockedSynchronizers = this.info.getLockedSynchronizers();
        if (lockedSynchronizers.length > 0) {
            sb.append("\n\tNumber of locked synchronizers = ").append(lockedSynchronizers.length).append('\n');
            for (final LockInfo lockInfo : lockedSynchronizers) {
                sb.append("\t- ");
                this.formatLock(sb, lockInfo);
                sb.append('\n');
            }
        }
    }
    
    private void formatLock(final StringBuilder sb, final LockInfo lockInfo) {
        sb.append("<").append(lockInfo.getIdentityHashCode()).append("> (a ");
        sb.append(lockInfo.getClassName()).append(")");
    }
    
    private void formatState(final StringBuilder sb, final ThreadInfo threadInfo) {
        final Thread.State threadState = threadInfo.getThreadState();
        sb.append(threadState);
        switch (threadState) {
            case BLOCKED: {
                sb.append(" (on object monitor owned by \"");
                sb.append(threadInfo.getLockOwnerName()).append("\" Id=").append(threadInfo.getLockOwnerId()).append(")");
                break;
            }
            case WAITING: {
                final StackTraceElement stackTraceElement = threadInfo.getStackTrace()[0];
                final String className = stackTraceElement.getClassName();
                final String methodName = stackTraceElement.getMethodName();
                if (className.equals("java.lang.Object") && methodName.equals("wait")) {
                    sb.append(" (on object monitor");
                    if (threadInfo.getLockOwnerName() != null) {
                        sb.append(" owned by \"");
                        sb.append(threadInfo.getLockOwnerName()).append("\" Id=").append(threadInfo.getLockOwnerId());
                    }
                    sb.append(")");
                    break;
                }
                if (className.equals("java.lang.Thread") && methodName.equals("join")) {
                    sb.append(" (on completion of thread ").append(threadInfo.getLockOwnerId()).append(")");
                    break;
                }
                sb.append(" (parking for lock");
                if (threadInfo.getLockOwnerName() != null) {
                    sb.append(" owned by \"");
                    sb.append(threadInfo.getLockOwnerName()).append("\" Id=").append(threadInfo.getLockOwnerId());
                }
                sb.append(")");
                break;
            }
            case TIMED_WAITING: {
                final StackTraceElement stackTraceElement2 = threadInfo.getStackTrace()[0];
                final String className2 = stackTraceElement2.getClassName();
                final String methodName2 = stackTraceElement2.getMethodName();
                if (className2.equals("java.lang.Object") && methodName2.equals("wait")) {
                    sb.append(" (on object monitor");
                    if (threadInfo.getLockOwnerName() != null) {
                        sb.append(" owned by \"");
                        sb.append(threadInfo.getLockOwnerName()).append("\" Id=").append(threadInfo.getLockOwnerId());
                    }
                    sb.append(")");
                    break;
                }
                if (className2.equals("java.lang.Thread") && methodName2.equals("sleep")) {
                    sb.append(" (sleeping)");
                    break;
                }
                if (className2.equals("java.lang.Thread") && methodName2.equals("join")) {
                    sb.append(" (on completion of thread ").append(threadInfo.getLockOwnerId()).append(")");
                    break;
                }
                sb.append(" (parking for lock");
                if (threadInfo.getLockOwnerName() != null) {
                    sb.append(" owned by \"");
                    sb.append(threadInfo.getLockOwnerName()).append("\" Id=").append(threadInfo.getLockOwnerId());
                }
                sb.append(")");
                break;
            }
        }
    }
}
