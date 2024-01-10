package org.example;

public class Triangulo {
    public TipoTriangulo tipoDeTriangulo(int a, int b, int c){
        if(a<=0 || b<=0 || c<=0){
            return TipoTriangulo.NoEsUnTriangulo;
        }else if(a==b && b==c){
            return TipoTriangulo.Equilatero;
        }else if(a==b || b==c || a==c){
            return TipoTriangulo.Isosceles;
        }else{
            return TipoTriangulo.Escaleno;
        }
    }
}
