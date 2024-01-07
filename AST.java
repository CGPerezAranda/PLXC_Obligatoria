
public class AST {	
	public String raiz;   
	public AST izq;
	public AST der;
	public String v;
	public String f;
	
	public AST (String r, AST i, AST d){
		raiz = r;
		izq = i;
		der = d;
	}
	
	public String gc(){
		String res = "";
		String left = "";
		String right = "";
		String temp = "";
		String aux = "";
		String et = "";
		String s = "";
		TablaSimbolos.Tipo tipo;

		switch(raiz) {
			case "ini":
				izq.gc();
				break;
			case "sent":
				izq.gc();
				if(der != null){
					der.gc();
				}
				break;
			case "print":
				left = izq.gc();
				if(!TablaSimbolos.estaIdent(left)){
					Errores.noDeclarada(left);
				}else{
					if(TablaSimbolos.tipo(left) == TablaSimbolos.Tipo.CHAR || izq.raiz.equals("castChar")){
						PLXC.out.println("\tprintc " + left + ";");
					}else{
						PLXC.out.println("\tprint " + left + ";");
					}			
				}
				/* if (izq.raiz.equals("ident")){
					if(TablaSimbolos.estaIdent(izq.izq.raiz)){
						aux = izq.gc();
						if(TablaSimbolos.tipo(izq.izq.raiz) == TablaSimbolos.Tipo.CHAR){
							PLXC.out.println("\tprintc " + aux + ";");
						}else{						
							PLXC.out.println("\tprint " + aux + ";");
						}
					} else {
						Errores.noDeclarada(aux);
					}
				}else if (izq.raiz.equals("ascii")){
					aux = izq.gc();
					PLXC.out.println("\tprintc " + aux + ";");
				}else{
					aux = izq.gc();
					PLXC.out.println("\tprint " + aux + ";");
				} */
				break;
			case "num":
				res += izq.raiz;
				if(!TablaSimbolos.estaIdent(res)){
					TablaSimbolos.insertar(res, TablaSimbolos.Tipo.INT);
				}
				break;
			case "real":
				res += izq.raiz;
				if(!TablaSimbolos.estaIdent(res)){
					TablaSimbolos.insertar(res, TablaSimbolos.Tipo.FLOAT);
				}
				break;
			case "castChar":
				aux = izq.gc();
				res += aux;
				//TablaSimbolos.setTipo(aux, TablaSimbolos.Tipo.CHAR);
				break;	
			case "castInt":
				aux = izq.gc();
				aux = ("(int) " + aux);
				v = Generador.nuevaVariable();
				PLXC.out.println("\t$" + v + " = " + aux + ";");
				res = "$" + v;
				TablaSimbolos.insertar(res, TablaSimbolos.Tipo.FLOAT);
				break;
			case "castFloat":
				aux = izq.gc();
				aux = ("(float) " + aux);
				v = Generador.nuevaVariable();
				PLXC.out.println("\t$" + v + " = " + aux + ";");
				res = "$" + v;
				TablaSimbolos.insertar(res, TablaSimbolos.Tipo.FLOAT);							
				break;
			case "arrayInt":
				aux = izq.raiz;
				Integer tam = Integer.parseInt(der.raiz);				
				if(!TablaSimbolos.estaIdent(aux)){
					TablaSimbolos.insertar(aux, TablaSimbolos.Tipo.ARRAY_INT);
					TablaSimbolos.declararTamanio(aux, tam);
				}else{
					Errores.varDeclarada(aux);
				}
				PLXC.out.println("\t" + "$" + aux + "_length = " + tam + ";");
				break;
			case "arrayChar":
				aux = izq.raiz;
				tam = Integer.parseInt(der.raiz);
				if(!TablaSimbolos.estaIdent(aux)){
					TablaSimbolos.insertar(aux, TablaSimbolos.Tipo.ARRAY_CHAR);
					TablaSimbolos.declararTamanio(aux, tam);
				}else{
					Errores.varDeclarada(aux);
				}
				PLXC.out.println("\t" + "$" + aux + "_length = " + tam + ";");
				break;
			case "arrayFloat":
				aux = izq.raiz;
				tam = Integer.parseInt(der.raiz);
				if(!TablaSimbolos.estaIdent(aux)){
					TablaSimbolos.insertar(aux, TablaSimbolos.Tipo.ARRAY_FLOAT);
					TablaSimbolos.declararTamanio(aux, tam);
				}else{
					Errores.varDeclarada(aux);
				}
				PLXC.out.println("\t" + "$" + aux + "_length = " + tam + ";");
				break;	
			case "ascii":
				res += izq.raiz;
				if(!(res.charAt(0) == '\\' && res.charAt(1)=='u')){ //ASCII
					if(res.length() == 1){
						s = String.valueOf((int) res.charAt(0));
					}else{
						char especial = res.charAt(0);
						switch(especial){
							case 'n':
								s = "10";
								break;
							case 't':
								s = "9";
								break;
							case 'r':
								s = "13";
								break;
							case '\\':
								s = "92";
								break;
							case '\'':
								s = "39";
								break;
							case '\"':
								s = "34";
								break;
							case 'f':
								s = "12";
								break;
							case 'b':
								s = "8";
								break;
						}
					}
				}else { //UNICODE
					s = Integer.decode("0x" + res.substring(2,6)).toString();
				} 
				if (!TablaSimbolos.estaIdent(s)){
					TablaSimbolos.insertar(s, TablaSimbolos.Tipo.CHAR);
				/* }else if (TablaSimbolos.tipo(s) == TablaSimbolos.Tipo.CHAR){
					Errores.varDeclarada(s); */
				}else {
					TablaSimbolos.setTipo(s, TablaSimbolos.Tipo.CHAR);
				}
				res = s;
				break;
			case "por":
				left = izq.gc();
				right = der.gc();
				tipo = TablaSimbolos.tipo(left);
				temp = Generador.nuevaVariable();
				if (tipo == TablaSimbolos.Tipo.FLOAT || TablaSimbolos.tipo(right) == TablaSimbolos.Tipo.FLOAT){
					tipo = TablaSimbolos.Tipo.FLOAT;
					TablaSimbolos.setTipo(left, TablaSimbolos.Tipo.FLOAT);
					TablaSimbolos.setTipo(right, TablaSimbolos.Tipo.FLOAT);
					PLXC.out.println("\t$" + temp + " = "+ left + " *r " + right + ";" );
				}else{
					PLXC.out.println("\t$" + temp + " = " + left + " * " + right + ";" );}
				if (tipo == TablaSimbolos.Tipo.CHAR){
					tipo = TablaSimbolos.Tipo.INT;
				}				
				TablaSimbolos.insertar("$" + temp, tipo);
				res += "$" + temp;				
				break;
			case "mas":
				left = izq.gc();
				right = der.gc();
				temp = Generador.nuevaVariable();				
				if((der.raiz.equals("castInt") || izq.raiz.equals("castInt"))){
					tipo = TablaSimbolos.Tipo.INT;
				}else{
					tipo = resuelveTipo(right, left);
				}
				TablaSimbolos.setTipo(left, tipo);
				TablaSimbolos.setTipo(right, tipo);
				if(tipo == TablaSimbolos.Tipo.FLOAT){
					PLXC.out.println("\t$" + temp + " = "+ left + " +r " + right + ";" );
				}else{
					PLXC.out.println("\t$" + temp + " = " + left + " + " + right + ";" );
				}
				/* if (tipo == TablaSimbolos.Tipo.FLOAT || TablaSimbolos.tipo(right) == TablaSimbolos.Tipo.FLOAT){
					tipo = TablaSimbolos.Tipo.FLOAT;
					TablaSimbolos.setTipo(left, TablaSimbolos.Tipo.FLOAT);
					TablaSimbolos.setTipo(right, TablaSimbolos.Tipo.FLOAT);
					PLXC.out.println("\t$" + temp + " = "+ left + " +r " + right + ";" );
				}else{
					PLXC.out.println("\t$" + temp + " = " + left + " + " + right + ";" );
				}	
				if (tipo == TablaSimbolos.Tipo.CHAR){
					tipo = TablaSimbolos.Tipo.INT;
				}	 */	
				TablaSimbolos.insertar("$" + temp, tipo);
				res += "$" + temp;				
				break;
			case "menos":
				left = izq.gc();
				right = der.gc();
				tipo = TablaSimbolos.tipo(left);
				temp = Generador.nuevaVariable();
				if (tipo == TablaSimbolos.Tipo.FLOAT || TablaSimbolos.tipo(right) == TablaSimbolos.Tipo.FLOAT){
					tipo = TablaSimbolos.Tipo.FLOAT;
					TablaSimbolos.setTipo(left, TablaSimbolos.Tipo.FLOAT);
					TablaSimbolos.setTipo(right, TablaSimbolos.Tipo.FLOAT);
					PLXC.out.println("\t$" + temp + " = "+ left + " -r " + right + ";" );
				}else{
					PLXC.out.println("\t$" + temp + " = " + left + " - " + right + ";" );
				}	
				if (tipo == TablaSimbolos.Tipo.CHAR){
					tipo = TablaSimbolos.Tipo.INT;
				}			
				TablaSimbolos.insertar("$" + temp, tipo);
				res += "$" + temp;				
				break;
			case "menosUnario":
				aux = izq.gc();
				left = "-" + aux;
				temp = Generador.nuevaVariable();
				PLXC.out.println("\t$" + temp + " = " + left + ";");
				TablaSimbolos.insertar("$" + temp, TablaSimbolos.tipo(aux));
				res += "$" + temp;
				break;
			case "asig":
				left = izq.raiz;
				right = der.gc();
				if (!TablaSimbolos.estaIdent(left)){
					Errores.noDeclarada(left);
				}
				if (TablaSimbolos.tipo(left) != TablaSimbolos.tipo(right) && !comprobarCasteo(left, der.raiz, right)){
						Errores.noTipo();
				} else {
					PLXC.out.println("\t" + left + " = " + right + ";");
				} if (!der.raiz.equals("asig")){
					res = right;
				} else {
					res = left;
				}				
				break;
			case "arrayAsig":
				left = izq.raiz; //identificador
				right = der.gc(); //valor
				aux = izq.izq.raiz; //indice
				tipo = TablaSimbolos.tipo(left);
				if(comprobarTipoArray(tipo, right)){
					v = Generador.nuevaEtiqueta();
					f = Generador.nuevaEtiqueta();
					PLXC.out.println("\tif (" + aux + " < 0) goto " + v + ";");
					PLXC.out.println("\tif ("+ TablaSimbolos.getTamanio(left) + " < " + aux + ") goto " + v + ";");
					PLXC.out.println("\tif ("+ TablaSimbolos.getTamanio(left) + " == " + aux + ") goto " + v + ";");
					PLXC.out.println("\tgoto " + f + ";");
					PLXC.out.println(v + ":");
					PLXC.out.println("\terror;\n\thalt;");
					PLXC.out.println(f + ":");
					PLXC.out.println("\t" + left + "[" + aux + "] = " + right + ";");
				}
				break;
			case "arrayPos":
				left = izq.raiz; //identificador
				right = der.raiz; //indice
				temp = Generador.nuevaVariable();
				v = Generador.nuevaEtiqueta();
				f = Generador.nuevaEtiqueta();
				tipo = resuelveTipo(TablaSimbolos.tipo(left));
				PLXC.out.println("\tif (" + right + " < 0) goto " + v + ";");
				PLXC.out.println("\tif ("+ TablaSimbolos.getTamanio(left) + " < " + right + ") goto " + v + ";");
				PLXC.out.println("\tif ("+ TablaSimbolos.getTamanio(left) + " == " + right + ") goto " + v + ";");
				PLXC.out.println("\tgoto " + f + ";");
				PLXC.out.println(v + ":");
				PLXC.out.println("\terror;\n\thalt;");
				PLXC.out.println(f + ":");
				PLXC.out.println("\t" + "$" + temp + " = " + left + "[" + right + "];");
				TablaSimbolos.insertar("$" + temp, tipo);
				res += "$" + temp;
				break;
			case "iniArray":
				left = izq.raiz; //identificador
				temp = Generador.getVarArray();
				der.gc();
				aux = Generador.getVarArray();
				for (int i = 0; i < Generador.getCurrentIndex(); i++){
					PLXC.out.println("\t" + "$" + aux + " = " + "$" + temp + "[" + i + "];");
					PLXC.out.println("\t" + left + "[" + i + "] = $" + aux + ";");
				}
				Generador.resetIndex();
				break;
			case "arrayIni":
				temp = Generador.getCurrentVarArray();
				left = izq.gc(); //valor a asignar	
				PLXC.out.println("\t" + "$" + temp + "[" + Generador.getindex() + "]" + " = " + left + ";");
				if(der != null) der.gc();						
				break;
			case "div":
				right = der.gc();
				left = izq.gc();
				tipo = TablaSimbolos.tipo(left);
				temp = Generador.nuevaVariable();
				if (tipo == TablaSimbolos.Tipo.FLOAT || TablaSimbolos.tipo(right) == TablaSimbolos.Tipo.FLOAT){
					tipo = TablaSimbolos.Tipo.FLOAT;
					TablaSimbolos.setTipo(left, TablaSimbolos.Tipo.FLOAT);
					TablaSimbolos.setTipo(right, TablaSimbolos.Tipo.FLOAT);
					PLXC.out.println("\t$" + temp + " = "+ left + " /r " + right + ";" );
				}else{
					PLXC.out.println("\t$" + temp + " = " + left + " / " + right + ";" );
				}
				if (tipo == TablaSimbolos.Tipo.CHAR){
					tipo = TablaSimbolos.Tipo.FLOAT;
				}			
				TablaSimbolos.insertar("$" + temp, tipo);
				res += "$" + temp;				
				break;
			case "ident":
				res += izq.raiz;
				break;
			case "if":
				izq.gc();
				PLXC.out.println( izq.v + ":");
				der.v = izq.v;
				der.f = izq.f;
				der.gc();
				break;
			case "igual":
				left = izq.gc();
				right = der.gc();
				v = Generador.nuevaEtiqueta();
				f = Generador.nuevaEtiqueta();
				PLXC.out.println("\tif (" + left + " == " + right + ") goto " + v + ";");
				PLXC.out.println("\tgoto " + f + ";");
				break;
			case "else":
				String l = Generador.nuevaEtiqueta();
				izq.gc();
				PLXC.out.println("\tgoto " + l + ";");
				PLXC.out.println( f + ":");
				if(der!=null){
					der.gc();
				}
				PLXC.out.println( l + ":");
				break;
			case "menorIgual":
				left = izq.gc();
				right = der.gc();
				v = Generador.nuevaEtiqueta();
				f = Generador.nuevaEtiqueta();
				PLXC.out.println("\tif (" + right + " < " + left + ") goto " + f +";");
				PLXC.out.println("\tgoto " + v + ";");
				break;
			case "mayorIgual":
				left = izq.gc();
				right = der.gc();
				v = Generador.nuevaEtiqueta();
				f = Generador.nuevaEtiqueta();
				PLXC.out.println("\tif (" + left + " < " + right + ") goto " + f +";");
				PLXC.out.println("\tgoto " + v + ";");
				break;
			case "distinto":
				left = izq.gc();
				right = der.gc();
				v = Generador.nuevaEtiqueta();
				f = Generador.nuevaEtiqueta();
				PLXC.out.println("\tif (" + left + " == " + right + ") goto " + f + ";");
				PLXC.out.println("\tgoto " + v + ";");
				break;
			case "and":
				izq.gc();
				PLXC.out.println(izq.v + ":");
				der.gc();
				PLXC.out.println(izq.f + ":");
				PLXC.out.println("\tgoto " + der.f + ";");
				v = der.v;
				f = der.f;
				break;
			case "or":
				izq.gc();
				PLXC.out.println(izq.f + ":");
				der.gc();
				PLXC.out.println(izq.v + ":");
				PLXC.out.println("\tgoto " + der.v + ";");
				v = der.v;
				f = der.f;
				break;
			case "not":
				izq.gc();
				v = izq.f;
				f = izq.v;
				break;
			case "mayor":
				left = izq.gc();
				right = der.gc();
				v = Generador.nuevaEtiqueta();
				f = Generador.nuevaEtiqueta();
				PLXC.out.println("\tif (" + right + " < " + left + ") goto " + v + ";");
				PLXC.out.println("\tgoto " + f + ";");
				break;
			case "menor":
				left = izq.gc();
				right = der.gc();
				v = Generador.nuevaEtiqueta();
				f = Generador.nuevaEtiqueta();
				PLXC.out.println("\tif (" + left + " < " + right + ") goto " + v + ";");
				PLXC.out.println("\tgoto " + f + ";");
				break;
			case "int":
				izq.gc();
				break;
			case "char":
				izq.gc();
				break;
			case "float":
				izq.gc();
				break;	
			case "floatIdent":
				TablaSimbolos.insertar(der.raiz, TablaSimbolos.Tipo.FLOAT);
				if (izq != null){
					izq.gc();
				}
				break;
			case "asigChar":
				right = der.raiz;
				if (!TablaSimbolos.estaIdent(right)){
					TablaSimbolos.insertar(right, TablaSimbolos.Tipo.CHAR);
				}else if (TablaSimbolos.tipo(right) == TablaSimbolos.Tipo.CHAR){
					Errores.varDeclarada(right);
				}else {
					TablaSimbolos.setTipo(right, TablaSimbolos.Tipo.CHAR);
				}
				PLXC.out.println("\t" + right + " = " + der.izq.gc() + ";");
				if(izq != null){
					izq.gc();
				}
				break;
			case "asigInt":
				right = der.raiz;
				if (!TablaSimbolos.estaIdent(right)){
					TablaSimbolos.insertar(right, TablaSimbolos.Tipo.INT);
				}else if (TablaSimbolos.tipo(right) == TablaSimbolos.Tipo.INT){
					Errores.varDeclarada(right);
				}else {
					TablaSimbolos.setTipo(right, TablaSimbolos.Tipo.INT);
				}
				PLXC.out.println("\t" + right + " = " + der.izq.gc() + ";");
				if(izq != null){
					izq.gc();
				}
				break;
			case "asigFloat":
				right = der.raiz;
				if (!TablaSimbolos.estaIdent(right)){
					TablaSimbolos.insertar(right, TablaSimbolos.Tipo.FLOAT);
				}else if (TablaSimbolos.tipo(right) == TablaSimbolos.Tipo.FLOAT){
					Errores.varDeclarada(right);
				}else {
					TablaSimbolos.setTipo(right, TablaSimbolos.Tipo.FLOAT);
				}
				PLXC.out.println("\t" + right + " = " + der.izq.gc() + ";");
				if(izq != null){
					izq.gc();
				}
				break;
			case "intIdent":
				TablaSimbolos.insertar(der.raiz, TablaSimbolos.Tipo.INT);
				if (izq != null){
					izq.gc();
				}
				break;
			case "charIdent":
				if (!TablaSimbolos.estaIdent(der.raiz)){
					TablaSimbolos.insertar(der.raiz, TablaSimbolos.Tipo.CHAR);
				}else if (TablaSimbolos.tipo(der.raiz) == TablaSimbolos.Tipo.CHAR){
					Errores.varDeclarada(der.raiz);
				}else {
					TablaSimbolos.setTipo(der.raiz, TablaSimbolos.Tipo.CHAR);
				}
				if(izq != null){
					izq.gc();
				}
				break;
			case "while":
			    et = Generador.nuevaEtiqueta();
				PLXC.out.println(et + ":");
				izq.gc();
				PLXC.out.println(izq.v + ":");
				der.gc();
				PLXC.out.println("\tgoto " + et + ";");
				PLXC.out.println(izq.f + ":");
				break;
			case "doWhile":
				et = Generador.nuevaEtiqueta();
				PLXC.out.println(et + ":");
				der.gc();
				izq.gc();
				PLXC.out.println(izq.v + ":");
				PLXC.out.println("\tgoto " + et + ";");
				PLXC.out.println(izq.f + ":");
				break;
			case "for":			    
				aux = izq.gc();
				if(izq.raiz.equals("expFor")) PLXC.out.println(izq.v + ":");
				der.gc(); //sentencia
				PLXC.out.println("\tgoto " + aux + ";");
				PLXC.out.println(izq.f + ":");
				break;
			case "expFor":
				if (der.izq != null) {
					der.izq.gc(); //aux.izq
				}
				et = Generador.nuevaEtiqueta();
				PLXC.out.println(et + ":");
				izq.gc(); //expfor
				String et2 = Generador.nuevaEtiqueta();
				PLXC.out.println(et2 + ":");
				if (der.der!=null) {
					der.der.gc(); //aux.der
				}
				PLXC.out.println("\tgoto " + et + ";");
				v = izq.v;
				f = izq.f;
				s = et2;
				res = s;
				break;
		}
		
		return res;
	}



	private TablaSimbolos.Tipo resuelveTipo (TablaSimbolos.Tipo tipo){
		TablaSimbolos.Tipo result = TablaSimbolos.Tipo.INT;
		switch (tipo) {
			case ARRAY_CHAR:
				return TablaSimbolos.Tipo.CHAR;
			case ARRAY_INT:
				return TablaSimbolos.Tipo.INT;
			case ARRAY_FLOAT:
				return TablaSimbolos.Tipo.FLOAT;
			default:
				break;
		}
		return result;
	}

	private TablaSimbolos.Tipo resuelveTipo(String right, String left) {
		TablaSimbolos.Tipo tipo = TablaSimbolos.Tipo.INT;
		if(TablaSimbolos.tipo(left) == TablaSimbolos.tipo(right)){
			if(TablaSimbolos.tipo(left) == TablaSimbolos.Tipo.ARRAY_CHAR){
				tipo = TablaSimbolos.Tipo.CHAR;
			}else if(TablaSimbolos.tipo(left) == TablaSimbolos.Tipo.ARRAY_INT){	
				tipo = TablaSimbolos.Tipo.INT;
			}else {
				tipo = TablaSimbolos.tipo(left);
			}
		}else if(((TablaSimbolos.tipo(left) == TablaSimbolos.Tipo.FLOAT) && (TablaSimbolos.tipo(right) != TablaSimbolos.Tipo.STRING))
				|| ((TablaSimbolos.tipo(right) == TablaSimbolos.Tipo.FLOAT) && (TablaSimbolos.tipo(left) != TablaSimbolos.Tipo.STRING))){	
			tipo = TablaSimbolos.Tipo.FLOAT;
		}else if((TablaSimbolos.tipo(left) == TablaSimbolos.Tipo.CHAR) && (TablaSimbolos.tipo(right) == TablaSimbolos.Tipo.INT) 
				|| (TablaSimbolos.tipo(left) == TablaSimbolos.Tipo.INT) && (TablaSimbolos.tipo(right) == TablaSimbolos.Tipo.CHAR)){
			tipo = TablaSimbolos.Tipo.INT;
		}else{
			Errores.noTipo();
		}
		return tipo;
	}

	private boolean comprobarTipoArray(TablaSimbolos.Tipo tipo, String right) {
		boolean result = false;
		if(tipo == TablaSimbolos.Tipo.ARRAY_INT && TablaSimbolos.tipo(right) == TablaSimbolos.Tipo.INT){
			result = true;
		}else if(tipo == TablaSimbolos.Tipo.ARRAY_CHAR && TablaSimbolos.tipo(right) == TablaSimbolos.Tipo.CHAR){
			result = true;
		}else if(tipo == TablaSimbolos.Tipo.ARRAY_FLOAT && TablaSimbolos.tipo(right) == TablaSimbolos.Tipo.FLOAT){
			result = true;
		}else{
			Errores.noTipo();
		}
		return result;
	}

	private boolean comprobarCasteo(String left, String raiz, String derecha) {
		boolean result = false;
		if(raiz.equals("castChar")){
			if(TablaSimbolos.tipo(left) == TablaSimbolos.Tipo.CHAR){
				result = true;
			}
		}else if(raiz.equals("castInt")){
			if(TablaSimbolos.tipo(left) == TablaSimbolos.Tipo.INT){
				result = true;
			}
		}else if(raiz.equals("castFloat")){
			if(TablaSimbolos.tipo(left) == TablaSimbolos.Tipo.FLOAT){
				result = true;
			}
		}else if(TablaSimbolos.tipo(left) == TablaSimbolos.Tipo.FLOAT && TablaSimbolos.tipo(derecha) == TablaSimbolos.Tipo.INT){
			result = true;
		}
		return result;
	}

}

/*
if ( 2 == 2 || 3 == 3 ) print (2*3);

   if (2 == 2) goto L0;
   goto L1;
L1:
   if (3 == 3) goto L2;
   goto L3;
L0:
   goto L2;
L2:
   $0 = 2 * 3;
   print $0;
   goto L4;
L3:
L4:

*/
