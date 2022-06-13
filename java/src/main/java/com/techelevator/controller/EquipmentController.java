package com.techelevator.controller;

import com.techelevator.dao.EquipmentDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Activity;
import com.techelevator.model.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class EquipmentController
{
    @Autowired
    private EquipmentDao equipmentDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/equipment", method = RequestMethod.GET)
    public List<Equipment> getEquipmentById(Principal principal)
    {
        int userId = userDao.findIdByUsername(principal.getName());
        return equipmentDao.getEquipmentByUser(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/equipment", method = RequestMethod.POST)
    public Equipment create(@RequestBody Equipment equipment, Principal principal)
    {
        int userId = userDao.findIdByUsername(principal.getName());
        return equipmentDao.createEquipment(equipment, userId);
    }
    @RequestMapping(path ="equipment/{equipmentId}", method = RequestMethod.PUT)
    public Equipment updateEquipment(@RequestBody Equipment equipment, @PathVariable int equipmentId)
    {
        return equipmentDao.updateEquipment(equipment, equipmentId);
    }
    @RequestMapping(path ="equipment/{equipmentId}", method = RequestMethod.DELETE)
    public void deleteEquipment(@PathVariable String equipmentId)
    {
        equipmentDao.deleteEquipment(Integer.parseInt(equipmentId));
    }
}
