package com.ibm.ServerWizard2;

import org.w3c.dom.Element;

public class SdrRecord {
	private String name = "";
	private String sdrName = "";
	private Integer sensorId = 0x00;
	private Integer entityId = 0x00;
	private Integer entityInstance = 0x00;
	private Integer sensorType = 0x00;
	private Target target = null;
	private String entityName = "";

	public String getAttributeValue() {
		return String.format("0x%02X%02X,0x%02X", sensorType,entityId,sensorId);
	}
	public void setTarget(Target target) {
		this.target=target;
	}
	public Target getTarget() {
		return target;
	}
	public String getName() {
		return name;
	}
	public String getSdrName() {
		return sdrName;
	}
	public Integer getSensorId() {
		return sensorId;
	}
	public Integer getSensorType() {
		return sensorType;
	}

	public Integer getEntityId() {
		return entityId;
	}
	public Integer getEntityInstance() {
		return entityInstance;
	}
	public void setEntityName(String entityName) {
		this.entityName=entityName;
	}
	public String getEntityName() {
		return this.entityName;
	}

	public void readXML(Element t) throws Exception {
		name = SystemModel.getElement(t, "name");
		try {
			sensorId = Integer.decode(SystemModel.getElement(t, "sensor_id"));
			entityId = Integer.decode(SystemModel.getElement(t, "entity_id"));
			sensorType = Integer.decode(SystemModel.getElement(t, "sensor_type"));
			entityInstance = Integer.decode(SystemModel.getElement(t, "entity_instance"));
		} catch (Exception e) {
			throw new Exception("Invalid SDR entry for: "+name);
		}
	}
	public String toString() {
		return String.format("%30s (%3d) Entity Id=%3d; Entity Inst=%3d; Sensor Type=%3d",name,sensorId,entityId,entityInstance,sensorType);
	}
}
