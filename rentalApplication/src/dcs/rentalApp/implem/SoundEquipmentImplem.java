package dcs.rentalApp.implem;

import java.util.HashMap;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import dcs.rentalApp.daointerface.SoundEquipmentDaoInterface;

public class SoundEquipmentImplem extends SqlSessionDaoSupport implements SoundEquipmentDaoInterface {
	
	public Object getEquipments() {
		return getSqlSession().selectList("TBL_SOUND_EQUPMENT.getEquipments");
	}
	
	public Object getEquipment() {
		return getSqlSession().selectOne("TBL_SOUND_EQUPMENT.getEquipment");
	}

	@Override
	public int addEquipment(HashMap<String, Object> values) {
		return getSqlSession().insert("addEquipment", values);
	}
}
