import com.xworkz.tour.dto.TourDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("com.xworkz");
       EntityManager entityManager= entityManagerFactory.createEntityManager();
        System.out.println("xml file is working");

        TourDTO tourDTO=new TourDTO();
        tourDTO.setName("KKR");
        tourDTO.setCountry("India");
        tourDTO.setCaptain("David Warner");
        tourDTO.setCategoryType("Cricket");
        EntityTransaction entityTransaction = entityManager.getTransaction();
        TourDTO tourDTO1= entityManager.find(TourDTO.class,2L);
        System.out.println(tourDTO1.getName());


        try {

            entityTransaction.begin();
            entityManager.persist(tourDTO);

            entityTransaction.commit();

        }
        catch(Exception e){
            System.out.println("Exception while inserting data");
            entityTransaction.rollback();
        }

        finally{
            entityManager.close();
            entityManagerFactory.close();
        }

        List<TourDTO> list=new ArrayList<>();

        TourDTO dto=new TourDTO();
        dto.setName("Gujrat Titans");
        dto.setCountry("India");
        dto.setCaptain("Shubham Gill");
        dto.setCategoryType("Cricket");

        TourDTO dto1=new TourDTO();
        dto1.setName("SRH");
        dto1.setCountry("India");
        dto1.setCaptain("Aiden Markram");
        dto1.setCategoryType("Cricket");

        TourDTO dto2=new TourDTO();
        dto2.setName("Rajasthan Royals");
        dto2.setCountry("India");
        dto2.setCaptain("Shreyas Iyer");
        dto2.setCategoryType("Cricket");

        TourDTO dto3=new TourDTO();
        dto3.setName("Punjab Kings");
        dto3.setCountry("India");
        dto3.setCaptain("Shikar Dhawan");
        dto3.setCategoryType("Cricket");

        TourDTO dto4=new TourDTO();
        dto4.setName("Delhi Capitals");
        dto4.setCountry("India");
        dto4.setCaptain("Rishabh Pant");
        dto4.setCategoryType("Cricket");

        list.add(dto);
        list.add(dto1);
        list.add(dto2);
        list.add(dto3);
        list.add(dto4);

        for(TourDTO list1:list){
            entityTransaction.begin();
            entityManager.persist(list1);
            entityTransaction.commit();
        }



    }
}
