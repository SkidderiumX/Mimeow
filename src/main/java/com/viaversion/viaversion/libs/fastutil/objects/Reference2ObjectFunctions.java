/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.Function;
import com.viaversion.viaversion.libs.fastutil.objects.AbstractReference2ObjectFunction;
import com.viaversion.viaversion.libs.fastutil.objects.Reference2ObjectFunction;
import com.viaversion.viaversion.libs.fastutil.objects.Reference2ObjectFunctions;
import java.io.Serializable;

public class Reference2ObjectFunctions {
    public static final EmptyFunction EMPTY_FUNCTION = new EmptyFunction();

    private Reference2ObjectFunctions() {
    }

    public static <K, V> Reference2ObjectFunction<K, V> singleton(K k, V v) {
        return new Singleton<K, V>(k, v);
    }

    public static <K, V> Reference2ObjectFunction<K, V> synchronize(Reference2ObjectFunction<K, V> reference2ObjectFunction) {
        return new SynchronizedFunction(reference2ObjectFunction);
    }

    public static <K, V> Reference2ObjectFunction<K, V> synchronize(Reference2ObjectFunction<K, V> reference2ObjectFunction, Object object) {
        return new SynchronizedFunction(reference2ObjectFunction, object);
    }

    public static <K, V> Reference2ObjectFunction<K, V> unmodifiable(Reference2ObjectFunction<? extends K, ? extends V> reference2ObjectFunction) {
        return new UnmodifiableFunction(reference2ObjectFunction);
    }

    public static class Singleton<K, V>
    extends AbstractReference2ObjectFunction<K, V>
    implements Serializable,
    Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final K key;
        protected final V value;

        protected Singleton(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override
        public boolean containsKey(Object object) {
            return this.key == object;
        }

        @Override
        public V get(Object object) {
            return (V)(this.key == object ? this.value : this.defRetValue);
        }

        @Override
        public V getOrDefault(Object object, V v) {
            return this.key == object ? this.value : v;
        }

        @Override
        public int size() {
            return 1;
        }

        public Object clone() {
            return this;
        }
    }

    public static class EmptyFunction<K, V>
    extends AbstractReference2ObjectFunction<K, V>
    implements Serializable,
    Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyFunction() {
        }

        @Override
        public V get(Object object) {
            return null;
        }

        @Override
        public V getOrDefault(Object object, V v) {
            return v;
        }

        @Override
        public boolean containsKey(Object object) {
            return false;
        }

        @Override
        public V defaultReturnValue() {
            return null;
        }

        @Override
        public void defaultReturnValue(V v) {
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

public static class SynchronizedFunction<K, V> implements Reference2ObjectFunction<K, V>, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;
		protected final Reference2ObjectFunction<K, V> function;
		protected final Object sync;

		protected SynchronizedFunction(final Reference2ObjectFunction<K, V> f, final Object sync) {
			if (f == null) throw new NullPointerException();
			this.function = f;
			this.sync = sync;
		}

		protected SynchronizedFunction(final Reference2ObjectFunction<K, V> f) {
			if (f == null) throw new NullPointerException();
			this.function = f;
			this.sync = this;
		}

		@Override
		public V apply(final K key) {
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
		public V defaultReturnValue() {
			synchronized (sync) {
				return function.defaultReturnValue();
			}
		}

		@Override
		public void defaultReturnValue(final V defRetValue) {
			synchronized (sync) {
				function.defaultReturnValue(defRetValue);
			}
		}

		@Override
		public boolean containsKey(final Object k) {
			synchronized (sync) {
				return function.containsKey(k);
			}
		}

		@Override
		public V put(final K k, final V v) {
			synchronized (sync) {
				return function.put(k, v);
			}
		}

		@Override
		public V get(final Object k) {
			synchronized (sync) {
				return function.get(k);
			}
		}

		@Override
		public V getOrDefault(final Object k, final V defaultValue) {
			synchronized (sync) {
				return function.getOrDefault(k, defaultValue);
			}
		}

		@Override
		public V remove(final Object k) {
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

public static class UnmodifiableFunction<K, V> extends AbstractReference2ObjectFunction<K, V> implements java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;
		protected final Reference2ObjectFunction<? extends K, ? extends V> function;

		protected UnmodifiableFunction(final Reference2ObjectFunction<? extends K, ? extends V> f) {
			if (f == null) throw new NullPointerException();
			this.function = f;
		}

		@Override
		public int size() {
			return function.size();
		}

		@Override
		public V defaultReturnValue() {
			return function.defaultReturnValue();
		}

		@Override
		public void defaultReturnValue(final V defRetValue) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean containsKey(final Object k) {
			return function.containsKey(k);
		}

		@Override
		public V put(final K k, final V v) {
			throw new UnsupportedOperationException();
		}

		@Override
		public V get(final Object k) {
			return function.get(k);
		}

		@Override
		@SuppressWarnings("unchecked")
		public V getOrDefault(final Object k, final V defaultValue) {
			return ((Reference2ObjectFunction<K, V>)function).getOrDefault(k, defaultValue);
		}

		@Override
		public V remove(final Object k) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void clear() {
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

