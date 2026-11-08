/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.Function;
import com.viaversion.viaversion.libs.fastutil.ints.AbstractInt2IntFunction;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntFunction;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntFunctions;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.IntUnaryOperator;

public class Int2IntFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Int2IntFunctions() {
    }

    public static Int2IntFunction singleton(int n, int n2) {
        return new Singleton(n, n2);
    }

    public static Int2IntFunction singleton(Integer n, Integer n2) {
        return new Singleton(n, n2);
    }

    public static Int2IntFunction synchronize(Int2IntFunction int2IntFunction) {
        return new SynchronizedFunction(int2IntFunction);
    }

    public static Int2IntFunction synchronize(Int2IntFunction int2IntFunction, Object object) {
        return new SynchronizedFunction(int2IntFunction, object);
    }

    public static Int2IntFunction unmodifiable(Int2IntFunction int2IntFunction) {
        return new UnmodifiableFunction(int2IntFunction);
    }

    public static Int2IntFunction primitive(java.util.function.Function<? super Integer, ? extends Integer> function) {
        Objects.requireNonNull(function);
        if (function instanceof Int2IntFunction) {
            return (Int2IntFunction)function;
        }
        if (function instanceof IntUnaryOperator) {
            return ((IntUnaryOperator)((Object)function))::applyAsInt;
        }
        return new PrimitiveFunction(function);
    }

    public static class Singleton
    extends AbstractInt2IntFunction
    implements Serializable,
    Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final int key;
        protected final int value;

        protected Singleton(int n, int n2) {
            this.key = n;
            this.value = n2;
        }

        @Override
        public boolean containsKey(int n) {
            return this.key == n;
        }

        @Override
        public int get(int n) {
            return this.key == n ? this.value : this.defRetValue;
        }

        @Override
        public int getOrDefault(int n, int n2) {
            return this.key == n ? this.value : n2;
        }

        @Override
        public int size() {
            return 1;
        }

        public Object clone() {
            return this;
        }
    }

    public static class PrimitiveFunction
    implements Int2IntFunction {
        protected final java.util.function.Function<? super Integer, ? extends Integer> function;

        protected PrimitiveFunction(java.util.function.Function<? super Integer, ? extends Integer> function) {
            this.function = function;
        }

        @Override
        public boolean containsKey(int n) {
            return this.function.apply((Integer)n) != null;
        }

        @Override
        @Deprecated
        public boolean containsKey(Object object) {
            if (object == null) {
                return false;
            }
            return this.function.apply((Integer)object) != null;
        }

        @Override
        public int get(int n) {
            Integer n2 = this.function.apply((Integer)n);
            if (n2 == null) {
                return this.defaultReturnValue();
            }
            return n2;
        }

        @Override
        public int getOrDefault(int n, int n2) {
            Integer n3 = this.function.apply((Integer)n);
            if (n3 == null) {
                return n2;
            }
            return n3;
        }

        @Override
        @Deprecated
        public Integer get(Object object) {
            if (object == null) {
                return null;
            }
            return this.function.apply((Integer)object);
        }

        @Override
        @Deprecated
        public Integer getOrDefault(Object object, Integer n) {
            if (object == null) {
                return n;
            }
            Integer n2 = this.function.apply((Integer)object);
            return n2 == null ? n : n2;
        }

        @Override
        @Deprecated
        public Integer put(Integer n, Integer n2) {
            throw new UnsupportedOperationException();
        }
    }

    public static class EmptyFunction
    extends AbstractInt2IntFunction
    implements Serializable,
    Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyFunction() {
        }

        @Override
        public int get(int n) {
            return 0;
        }

        @Override
        public int getOrDefault(int n, int n2) {
            return n2;
        }

        @Override
        public boolean containsKey(int n) {
            return false;
        }

        @Override
        public int defaultReturnValue() {
            return 0;
        }

        @Override
        public void defaultReturnValue(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public void clear() {
        }

        public Object clone() {
            return EMPTY_FUNCTION;
        }

        public int hashCode() {
            return 0;
        }

        public boolean equals(Object object) {
            if (!(object instanceof Function)) {
                return false;
            }
            return ((Function)object).size() == 0;
        }

        public String toString() {
            return "{}";
        }

        private Object readResolve() {
            return EMPTY_FUNCTION;
        }
    }

public static class SynchronizedFunction implements Int2IntFunction, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;
		protected final Int2IntFunction function;
		protected final Object sync;

		protected SynchronizedFunction(final Int2IntFunction f, final Object sync) {
			if (f == null) throw new NullPointerException();
			this.function = f;
			this.sync = sync;
		}

		protected SynchronizedFunction(final Int2IntFunction f) {
			if (f == null) throw new NullPointerException();
			this.function = f;
			this.sync = this;
		}

		@Override
		public int applyAsInt(int operand) {
			synchronized (sync) {
				return function.applyAsInt(operand);
			}
		}

		
		@Deprecated
		@Override
		public Integer apply(final Integer key) {
			synchronized (sync) {
				return function.apply(key);
			}
		}

		@Override
		public int size() {
			synchronized (sync) {
				return function.size();
			}
		}

		@Override
		public int defaultReturnValue() {
			synchronized (sync) {
				return function.defaultReturnValue();
			}
		}

		@Override
		public void defaultReturnValue(final int defRetValue) {
			synchronized (sync) {
				function.defaultReturnValue(defRetValue);
			}
		}

		@Override
		public boolean containsKey(final int k) {
			synchronized (sync) {
				return function.containsKey(k);
			}
		}

		@Deprecated
		@Override
		public boolean containsKey(final Object k) {
			synchronized (sync) {
				return function.containsKey(k);
			}
		}

		@Override
		public int put(final int k, final int v) {
			synchronized (sync) {
				return function.put(k, v);
			}
		}

		@Override
		public int get(final int k) {
			synchronized (sync) {
				return function.get(k);
			}
		}

		@Override
		public int getOrDefault(final int k, final int defaultValue) {
			synchronized (sync) {
				return function.getOrDefault(k, defaultValue);
			}
		}

		@Override
		public int remove(final int k) {
			synchronized (sync) {
				return function.remove(k);
			}
		}

		@Override
		public void clear() {
			synchronized (sync) {
				function.clear();
			}
		}

		
		@Deprecated
		@Override
		public Integer put(final Integer k, final Integer v) {
			synchronized (sync) {
				return function.put(k, v);
			}
		}

		
		@Deprecated
		@Override
		public Integer get(final Object k) {
			synchronized (sync) {
				return function.get(k);
			}
		}

		
		@Deprecated
		@Override
		public Integer getOrDefault(final Object k, final Integer defaultValue) {
			synchronized (sync) {
				return function.getOrDefault(k, defaultValue);
			}
		}

		
		@Deprecated
		@Override
		public Integer remove(final Object k) {
			synchronized (sync) {
				return function.remove(k);
			}
		}

		@Override
		public int hashCode() {
			synchronized (sync) {
				return function.hashCode();
			}
		}

		@Override
		public boolean equals(final Object o) {
			if (o == this) return true;
			synchronized (sync) {
				return function.equals(o);
			}
		}

		@Override
		public String toString() {
			synchronized (sync) {
				return function.toString();
			}
		}

		private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
			synchronized (sync) {
				s.defaultWriteObject();
			}
		}
	}

public static class UnmodifiableFunction extends AbstractInt2IntFunction implements java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;
		protected final Int2IntFunction function;

		protected UnmodifiableFunction(final Int2IntFunction f) {
			if (f == null) throw new NullPointerException();
			this.function = f;
		}

		@Override
		public int size() {
			return function.size();
		}

		@Override
		public int defaultReturnValue() {
			return function.defaultReturnValue();
		}

		@Override
		public void defaultReturnValue(final int defRetValue) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean containsKey(final int k) {
			return function.containsKey(k);
		}

		@Override
		public int put(final int k, final int v) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int get(final int k) {
			return function.get(k);
		}

		@Override
		public int getOrDefault(final int k, final int defaultValue) {
			return function.getOrDefault(k, defaultValue);
		}

		@Override
		public int remove(final int k) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void clear() {
			throw new UnsupportedOperationException();
		}

		
		@Deprecated
		@Override
		public Integer put(final Integer k, final Integer v) {
			throw new UnsupportedOperationException();
		}

		
		@Deprecated
		@Override
		public Integer get(final Object k) {
			return function.get(k);
		}

		
		@Deprecated
		@Override
		public Integer getOrDefault(final Object k, final Integer defaultValue) {
			return function.getOrDefault(k, defaultValue);
		}

		
		@Deprecated
		@Override
		public Integer remove(final Object k) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int hashCode() {
			return function.hashCode();
		}

		@Override
		public boolean equals(Object o) {
			return o == this || function.equals(o);
		}

		@Override
		public String toString() {
			return function.toString();
		}
	}
}

