package com.Itlize.projectmanager.services.serviceImp;

import com.Itlize.projectmanager.entities.ResourceColumn;
import com.Itlize.projectmanager.repositories.ResourceColumnRepository;
import com.Itlize.projectmanager.services.ResourceColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ResourceColumnImp implements ResourceColumnService {

    @Autowired
   ResourceColumnRepository resourceColumnRepository;

    public boolean createResourceColumn(ResourceColumn resourceColumn){
        ResourceColumn resourceColumn1 = new ResourceColumn();
        if (resourceColumn == null){

            System.out.println("Null object! cannot create");
            return false;

        } try{
             resourceColumn1 = resourceColumnRepository.save(resourceColumn);

        }catch (Exception e){
            e.printStackTrace();


        }
        return true;



    }

    public ResourceColumn readResourceColumn(Integer resourceColumnid){
        ResourceColumn  resourceColumn1 = new ResourceColumn();
        if (resourceColumnid == null){

            System.out.println("Null object! cannot create");
            return null;
        } try{
            resourceColumn1 = resourceColumnRepository.findById(resourceColumnid).orElse(null);

        }catch (Exception e){
            e.printStackTrace();
        }
        return resourceColumn1;
    }

    public boolean updateresourceColumnbyId(ResourceColumn resourceColumn, Integer resourceColumnid){
        ResourceColumn resourceColumn1 = new ResourceColumn();

        if (resourceColumn == null){

            System.out.println("Null object! cannot create");
            return false;
        } try{

            resourceColumn1 = resourceColumn;
            resourceColumn1.setResourceColumnId(resourceColumnid);

            resourceColumnRepository.save(resourceColumn1);

        }catch (Exception e){
            e.printStackTrace();
        }
        return true;

    }

    public boolean deleteResourceColumn(ResourceColumn resourceColumn){

        if (resourceColumn  == null ){
            System.out.println("Null object! cannot delete");
            return false;
        }try{
            resourceColumnRepository.delete(resourceColumn);

        }catch (Exception e){
            e.printStackTrace();
        }
        return true;

    }

}
