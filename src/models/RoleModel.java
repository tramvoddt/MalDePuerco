package models;

import java.sql.ResultSet;
import java.util.ArrayList;

import utils.CompareOperator;
import utils.DataMapping;

public class RoleModel extends BaseModel {
	private static String table = "roles";
	private static String[] columns = {"id, code, name, created_at, status"};
	private static RoleModel roleModel;
	
	private int id;
	private int sequence;
	private String code;
	private String name;
	private String createdAt;
	private int status;
	
	//status
	public static final int ROLE_ACTIVATED = 1;
	public static final int ROLE_DEACTIVATED = 0;
	public static DataMapping isActivated = DataMapping.getInstance(ROLE_ACTIVATED, "Activated");
	public static DataMapping isDeactivated = DataMapping.getInstance(ROLE_DEACTIVATED, "Deactivated");
	
	//constructor
	public RoleModel() {
		super(table, columns);
		if(roleModel != null) {
			roleModel = new RoleModel();
		}
	}
	
	public static RoleModel getInstance(int id, int sequence, String code, String name, String createdAt, int status) {
		if(roleModel != null) {
			roleModel = new RoleModel();
			roleModel.setId(id);
			roleModel.setSequence(sequence);
			roleModel.setCode(code);
			roleModel.setName(name);
			roleModel.setCreatedAt(createdAt);
			roleModel.setStatus(status);
			return roleModel;
		}
		return roleModel;
	}

	//get
	public ResultSet getRoleList(ArrayList<CompareOperator> conditions) {
		try {	
			return this.getData(columns, conditions, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//get data by id
	public ResultSet getRoleById(int id) {
		try {		
			ArrayList<CompareOperator> joinRole = new ArrayList<CompareOperator>();
			joinRole.add(CompareOperator.getInstance("id", " = ", String.valueOf(id)));
			
			return this.getData(columns, joinRole, null, null, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int createRole(ArrayList<DataMapping> data) {
		try {
			return this.create(data);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//update
	public boolean updateRoleById(int id, ArrayList<DataMapping> data) {
		try {
			
			ArrayList<CompareOperator> conditions = new ArrayList<CompareOperator>();
			conditions.add(CompareOperator.getInstance("id", "=", String.valueOf(id)));
			return this.update(data, conditions);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//delete
	public boolean deleteRoleById(int id) {
		try {
			ArrayList<CompareOperator> conditions = new ArrayList<CompareOperator>();
			conditions.add(CompareOperator.getInstance("id", "=", String.valueOf(id)));
			
			return this.delete(conditions);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//get & set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
