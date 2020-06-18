public class ListaDobleEnlazada{
			private NodoGen Inicio;
			private NodoGen Fin;
			private int NoElementos;
			public ListaDobleEnlazada() {
					Inicio = null;
					Fin = null;
					NoElementos = 0;
				}
				public int getNoElementos() {
					return NoElementos;
				}
				public void agregarAlInicio(NodoGen AG) {
/////////////////////////////////////////////////////////////////////////
					 if (Inicio == null) {
						Inicio = AG;
						Fin = AG;
						NoElementos++;
					}else {
/////////////////////////////////////////////////////////////////////////
						AG.Siguiente = Inicio;
						Inicio.Anterior = AG;
						Inicio = AG;
						NoElementos++;
					}
				}
				public void agregarAlFin(NodoGen AG) {
///////////////////////////////////////////////////////////////////////
					if (Fin == null) {
						Fin = AG;
						Inicio = AG;
						NoElementos++;
					}else {
						//La lista al menos tiene  un Nodo
						Fin.Siguiente=AG;
						AG.Anterior = Fin;
						Fin = AG;
						NoElementos++;
					}
				}
/////////////////////////////////////////////////////////////////////////				
				public boolean buscarElemento(NodoGen AB) {
					//El nodo no es nulo
					if (AB != null) {
						if (Inicio != null) {
							if (Inicio.getData() == AB.getData()) {
								return true;
							}
						}
						if (Fin != null) {
							if (Fin.getData() == AB.getData()) {
								return true;
							}
						}
////////////////////////////////////////////////////////////////////////////
						NodoGen ref = Inicio;
						boolean Encontrado = false;
						while ((ref != null)&& !Encontrado) {
							if (ref.getData() == AB.getData()) {
								Encontrado = true;
							}
							ref = ref.Siguiente;
							}
						return Encontrado;
					}
					return false; 
					}
				public NodoGen eliminarAlInicio() {
					if (Inicio == null) {
						return null;
					}else {
						NodoGen Ret = Inicio;
////////////////////////////////////////////////////////////////////////////						
					Inicio = Inicio.Siguiente;
					Inicio.Anterior = null;
					Ret.Siguiente = null;
					Ret.Anterior = null;
					NoElementos--;
					return Ret;
					}
				}
				public NodoGen eliminarAlFin() {
					if (Fin == null) {
						return null;
					}else {					
						NodoGen eliminar = Fin;
						Fin = Fin.Anterior;
						Fin.Siguiente = null;					
						eliminar.Siguiente = null;
						eliminar.Anterior = null;
						NoElementos--;
						return eliminar;
					}
				}
				public NodoGen eliminarPorNodo(NodoGen AB) {
					if (AB == null) {
						return null;
					}
					if (Fin == null) {
						return null;
					}else { 
///////////////////////////////////////////////////////////////////////////
						if (Inicio.getData() == AB.getData()) {
							return eliminarAlInicio();
						}
/////////////////////////////////////////////////////////////////////////						
						if (Fin.getData() == AB.getData()) {
							return eliminarAlFin();
						}
///////////////////////////////////////////////////////////////////////////
						NodoGen RefRojo = Inicio;
						NodoGen RefAzul = null;
						NodoGen RefElim = null;
						boolean Encontrado = false;
						while ((RefRojo != null)&& !Encontrado) {
							if (RefRojo.getData() == AB.getData()) {
								Encontrado = true;
								RefElim = RefRojo;
								NoElementos--;
							}
							RefRojo = RefRojo.Siguiente;
						}
						if (Encontrado) {
						RefRojo = RefElim.Anterior;
						RefAzul = RefElim.Siguiente;
						
						RefRojo.Siguiente = RefAzul;
						RefAzul.Anterior = RefRojo;
						
						RefElim.Siguiente = null;
						RefElim.Anterior=null;
						}
						return RefElim;
					}
				}
				public NodoGen porIndice(int p) {
					if (Inicio == null) {
						return null;
					}
					if (p >= NoElementos) {
						return null;
					}
					if (p < 0) {
						return null;
					}
					int i = 0;
					NodoGen Ref = Inicio;
					for (; i < p; i++) {
						Ref = Ref.Siguiente;
					}
					switch (Ref.getTipo()) {
					case 1:
						Ref = new NodoGen<Integer>((int)Ref.getData(),1);
						break;
					case 2:
						Ref = new NodoGen<Double>((double)Ref.getData(),2);
						break;
					case 3:
						Ref = new NodoGen<String>(""+Ref.getData(),3);
						break;
					case 4:
						Ref = new NodoGen<Float>((float)Ref.getData(),4);
						break;
					case 5:
						Ref = new NodoGen<Boolean>((boolean)Ref.getData(),5);
						break;
					case 6:
						Ref = new NodoGen<Character>((char)Ref.getData(),6);
						break;
					case 7:
						Ref = new NodoGen<Short>((short)Ref.getData(),7);
						break;
					case 8:
						Ref = new NodoGen<Long>((long)Ref.getData(),8);
						break;
					default:
					}
					return Ref;
				}
				public String toString() {
					String tmp = "";
					if (Inicio == null) {
						return "";
					}
					NodoGen ref = Inicio;
					while(ref != null) {
						tmp = tmp + " " + ref.toString();
						ref = ref.Siguiente;
					}
					return tmp;
				}
				public String toStringReverse() {
					String tmp = "";
					if (Fin == null) {
						return "";
					}
					NodoGen ref = Fin;
					while(ref != null) {
						tmp = tmp + " " + ref.toString();
						ref = ref.Anterior;
					}
					return tmp;
				}
				}