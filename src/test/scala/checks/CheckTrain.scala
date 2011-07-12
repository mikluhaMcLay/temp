package checks

import org.specs2._
import java.util.Date
import vehicle.{Locomotive, Car, ModelTrain}
import normativeReferenceInformation.{LocomotiveType, CarType}

/**
 * Developer: Михаил Бородин
 * Date: 11.07.11
 * Time: 17:10
 */
class CheckTrain extends Specification {

  object date extends Date

  object even extends CarType("", 103, 20)

  object odd extends CarType("", 12, 25)

  val repairMileage = 1234

  val train: ModelTrain = new ModelTrain()
  train.addAll(new Car(odd, repairMileage, date) :: new Car(even, repairMileage, date) ::
    new Car(odd, repairMileage, date) :: Nil)
  val headCar: Car = new Car(odd, 6543, date)
  train.addCar(headCar)
  val thirdCar: Car = new Car(odd, 3, date)
  train.addCar(3, thirdCar)
  train.addLoco(new Locomotive(new LocomotiveType("", 50, 80), repairMileage, date))


  def is = {
    "Проверка класса ModelTrain" ^
      "Вагонов в составе д.б. 5" ! (train.cars.size must be equalTo 5) ^
      "Суммарная длина состава д.б. 170" ! (train.realLength must be equalTo 170) ^
      "Вес состава д.б. = 131" ! (train.weight must be equalTo 131) ^
      "Первый вагон " ! (train.cars(0) == headCar) ^
      "Третий вагон" ! (train.cars(2) == thirdCar) ^
      end
  }
}