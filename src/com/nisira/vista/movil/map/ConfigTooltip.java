package com.nisira.vista.movil.map;

import java.awt.Color;

public class ConfigTooltip {
	public Integer numPisos;
	public long timer;
	public Integer pisoAlerta;
	public Integer tiempoCierre;
	public Color origen;
	public Color alerta;
	public ConfigTooltip(Integer p1,long p2,Integer p3,Integer p4,Color origen,Color alerta){
		this.numPisos=p1;
		this.timer=p2;
		this.pisoAlerta=p3;
		this.tiempoCierre=p4;
		this.origen=origen;
		this.alerta=alerta;
	}
}
