package example.controller;

import example.model.Weapon;
import example.service.WeaponService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation._;

import java.util.List;
import scala.collection.JavaConversions._

/**
 * @author ragcrix
 */
@RestController
@RequestMapping(Array("/weapons"))
class WeaponController @Autowired() (
  weaponService: WeaponService
){

  @GetMapping(Array("/name/{value}"))
  def getByName(@PathVariable("value") value: String): String = weaponService.findByName(value).toString()

  @GetMapping(Array("/"))
  def getAllWeapons(): String =
  {
    var sb = new StringBuilder();
    for ( w <- weaponService.findAll() ) {
      sb.append(w.toString()+"\n");
    }
    return sb.toString();
  }
}
