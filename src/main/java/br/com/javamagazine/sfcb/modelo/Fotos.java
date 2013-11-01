package br.com.javamagazine.sfcb.modelo;

import java.util.ArrayList;
import java.util.List;

public class Fotos {

    private List<Foto> fotos;
    private String proximaPagina;
    private String paginaAnterior;
    private int count = 100;

	public Fotos () {
        this.fotos = new ArrayList<Foto>();
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public String getPaginaAnterior() {
        return paginaAnterior;
    }

    public void setPaginaAnterior(String paginaAnterior) {
        this.paginaAnterior = paginaAnterior;
    }

    public String getProximaPagina() {
        return proximaPagina;
    }

    public void setProximaPagina(String proximaPagina) {
        this.proximaPagina = proximaPagina;
    }
    
    public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
