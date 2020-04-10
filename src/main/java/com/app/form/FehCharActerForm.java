package com.app.form;

import java.util.List;
import java.util.Map;

import com.app.model.ContentMaster;
import com.app.model.FehCharacter;

public class FehCharActerForm extends BaseForm{

	private FehCharacter charActer;
	
	private List<ContentMaster> origin;
	
	private List<ContentMaster> weaponType;
	
	Map<String,List<String>> skillMap;

	public FehCharacter getCharActer() {
		return charActer;
	}

	public void setCharActer(FehCharacter charActer) {
		this.charActer = charActer;
	}

	public List<ContentMaster> getOrigin() {
		return origin;
	}

	public void setOrigin(List<ContentMaster> origin) {
		this.origin = origin;
	}

	public List<ContentMaster> getWeaponType() {
		return weaponType;
	}

	public void setWeaponType(List<ContentMaster> weaponType) {
		this.weaponType = weaponType;
	}

	public Map<String, List<String>> getSkillMap() {
		return skillMap;
	}

	public void setSkillMap(Map<String, List<String>> skillMap) {
		this.skillMap = skillMap;
	}
	
	
}
