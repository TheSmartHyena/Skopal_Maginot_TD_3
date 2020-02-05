package factory;

import database.XmlClientDao;
import interfaces.dao.IClientDao;

public class XmlDaoFactory extends DaoFactory {

	@Override
	public IClientDao getClientDao() {
		return XmlClientDao.getInstance();
	}

}
