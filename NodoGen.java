public class NodoGen<T>{
	public NodoGen Anterior;
	public NodoGen Siguiente;
	private int Tipo;
	private T Data;
		public NodoGen(T Data, int Tipo) {
			this.Tipo = Tipo;
			this.Data = Data;
			Anterior = null;
			Siguiente = null;
		}
		public T getData() {
			return Data;
		}
		public void setData(T Data) {
			this.Data = Data;
		}
		public String toString() {
			return ""+Data;
		}
		public int getTipo() {
			return Tipo;
		}
}