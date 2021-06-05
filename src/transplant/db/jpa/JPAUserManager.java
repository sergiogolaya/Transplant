package transplant.db.jpa;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import transplant.db.ifaces.UserManager;
import transplant.db.pojos.users.Role;
import transplant.db.pojos.users.User;

public class JPAUserManager implements UserManager {
//because is going to be used by a lot of methods
	private EntityManager em;

	@Override
	public void connect() {
		//we create an entity manager like the user-provide type
		em = Persistence.createEntityManagerFactory("user-provider").createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em.getTransaction().commit();
		List<Role> existingRoles = this.getRoles();
		if (existingRoles.size()<3) {
			this.newRole(new Role("hospital"));
			this.newRole(new Role("patient"));
			this.newRole(new Role("donor"));
			}
	}

	@Override
	public void disconnect() {
		em.close();
	}

	@Override
	public void newUser(User u) {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
	}

	@Override
	public void newRole(Role r) {
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
	}

	@Override
	public Role getRole(int id) {
		Query q = em.createNativeQuery("SELECT * FROM roles WHERE id = ?", Role.class);
		q.setParameter(1, id);
		return (Role) q.getSingleResult();

	}

	@Override
	public List<Role> getRoles() {
		Query q = em.createNativeQuery("SELECT * FROM roles", Role.class);
		return (List<Role>) q.getResultList();
	}

	@Override
	public User checkPassword(String email, String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] hash = md.digest();
			Query q = em.createNativeQuery("SELECT * FROM users WHERE email = ? AND password = ?", User.class);
			q.setParameter(1, email);
			q.setParameter(2, hash);
			return (User) q.getSingleResult();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();//never going to happen
		} catch (NoResultException nre) {
			return null;//it doesn't exits
		}
		return null;
	}
	@Override
	public Boolean checkEmail(String email) {
		try {
			Query x = em.createNativeQuery("SELECT * FROM users WHERE email = ?", User.class);
			x.setParameter(1, email);
			User temp = (User)x.getSingleResult();
			if(temp.getEmail().equalsIgnoreCase(email)) {
				return true;
			}else {
				return false;
			}
		}catch(NoResultException ne) {
			return false;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
 
 
}
