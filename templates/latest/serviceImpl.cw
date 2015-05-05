@@[template:ServiceImpl Template]@@
@@[project:Codequick Sample]@@
@@[version:1.0]@@
@@[author:Marcelo Torres]@@
@@[licence:GNU GPL 3]@@

@@[fileType:Java]@@
@@[fileModule:ejb]@@
@@[filePath:@@[getVar:serviceImplPackageName]@@]@@
@@[filePrefix:]@@
@@[fileSufix:ServiceImpl.java]@@

@@[content:
package @@[getVar:servicePackageName]@@;

import java.util.List;

import com.codequick.common.data.DAOFactory;
import com.codequick.common.service.Command;
import com.codequick.common.service.ServiceBaseImpl;
import @@[getVar:daoPackageName]@@.@@[get:tableDef.className]@@DAO;
import @@[getVar:modelPackageName]@@.@@[get:tableDef.className]@@;
import @@[getVar:servicePackageName]@@.@@[get:tableDef.className]@@Service;

public class @@[get:tableDef.className]@@Service extends ServiceBaseImpl implements @@[get:tableDef.className]@@Service {
	
	public int delete(final @@[get:tableDef.className]@@ @@[lowerFirst:@@[get:tableDef.className]@@]@@) {
		final @@[get:tableDef.className]@@DAO dao = DAOFactory.instanceOf(@@[get:tableDef.className]@@DAO.class);
		Command<Integer> command = new Command<Integer>() {
			public Integer execute() {
				return dao.delete(@@[lowerFirst:@@[get:tableDef.className]@@]@@);
			}
		};
		
		return this.executeAndClose(command, dao);
	}
	
	public @@[get:tableDef.className]@@ findByID(final @@[get:tableDef.className]@@ @@[lowerFirst:@@[get:tableDef.className]@@]@@) {
		final @@[get:tableDef.className]@@DAO dao = DAOFactory.instanceOf(@@[get:tableDef.className]@@DAO.class);
		Command<@@[get:tableDef.className]@@> command = new Command<@@[get:tableDef.className]@@>() {
			public @@[get:tableDef.className]@@ execute() {
				return dao.findByID(@@[lowerFirst:@@[get:tableDef.className]@@]@@);
			}
		};
		
		return this.executeAndClose(command, dao);
	}
	
	public int insert(final @@[get:tableDef.className]@@ @@[lowerFirst:@@[get:tableDef.className]@@]@@) {
		final @@[get:tableDef.className]@@DAO dao = DAOFactory.instanceOf(@@[get:tableDef.className]@@DAO.class);
		
		return this.executeAndClose(new Command<Integer>() {
			public Integer execute() {
				return dao.insert(@@[lowerFirst:@@[get:tableDef.className]@@]@@);
			}
		}, dao);
	}
	
	public List<@@[get:tableDef.className]@@> listAll() {
		final @@[get:tableDef.className]@@DAO dao = DAOFactory.instanceOf(@@[get:tableDef.className]@@DAO.class);
		
		Command<List<@@[get:tableDef.className]@@>> command = new Command<List<@@[get:tableDef.className]@@>>() {
			public List<@@[get:tableDef.className]@@> execute() {
				return dao.listAll();
			}
		};
		
		return this.executeAndClose(command, dao);
	}
	
	public int update(final @@[get:tableDef.className]@@ @@[lowerFirst:@@[get:tableDef.className]@@]@@) {
		
		Command<Integer> command = new Command<Integer>() {
			public Integer execute() {
				@@[get:tableDef.className]@@DAO dao = DAOFactory.instanceOf(@@[get:tableDef.className]@@DAO.class);
				dao.setConnection(this.getConnection());
				return dao.update(@@[lowerFirst:@@[get:tableDef.className]@@]@@);
			}
		};
		
		return this.executeAndClose(command);
	}
	
}
]@@
