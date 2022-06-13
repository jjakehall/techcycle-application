package com.techelevator.dao;

import com.techelevator.model.Equipment;

import java.util.List;

public interface EquipmentDao
{
    List<Equipment> getEquipmentByUser (int userId);
    Equipment createEquipment(Equipment equipment, int userId);
    Equipment updateEquipment(Equipment updatedEquipment, int equipmentId);
    void deleteEquipment(int equipmentId);
}
