package domain;

import bl.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Domain {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Address address = new Address();
        address.setCountry("CZ");
        address.setCity("Praha");
        address.setStreet("Chaloupeckeho");
        address.setPostCode("16900");

        Employee employee = new Employee();
        employee.setFirstName("Darkhan");
        employee.setLastName("Bailov");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1996, Calendar.MARCH, 7);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Project project = new Project();
        project.setTitle("Diploma");

        Set<Project> projects = new HashSet<Project>();
        projects.add(project);
        employee.setProjects(projects);

        session.save(address);
        session.save(employee);
        session.save(project);

        session.getTransaction().commit();
        HibernateUtil.shutdown();

    }

}
