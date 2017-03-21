package com.nisira.alien;

import java.util.ArrayList;
import java.util.List;

import com.alien.enterpriseRFID.tags.Tag;
import com.nisira.entidad.ANTENA;

public class TagsRfid{
	private Tag tag;
	private ANTENA antena;
	public TagsRfid(Tag tag,ANTENA ant){
		this.setTag(tag);
		this.setAntena(ant);
	}
	public TagsRfid(ANTENA ant){
		this.setTag(null);
		this.setAntena(ant);
	}
	public TagsRfid(){
		this.setTag(null);
		this.setAntena(null);
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	public ANTENA getAntena() {
		return antena;
	}
	public void setAntena(ANTENA antena) {
		this.antena = antena;
	}
}
