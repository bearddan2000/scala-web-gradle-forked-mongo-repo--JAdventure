package example.service;

import example.model.Weapon;

import java.util.List;

/**
 * @author regcrix
 */
trait WeaponService {

    def findAll(): List[Weapon];

    def findByName(name: String): Weapon;

}
