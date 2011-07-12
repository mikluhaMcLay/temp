package vehicle

import normativeReferenceInformation.Station
import collection.mutable.{Traversable, ArrayBuffer}
import com.xj.anylogic.libraries.rail.{RailCar, Train}

/**
 * Developer: Михаил Бородин
 * Date: 08.07.11
 * Time: 15:21
 */
class ModelTrain extends Train {
  private var loco: Locomotive = null
  val cars: ArrayBuffer[Car] = new ArrayBuffer[Car]()
  var realLength: Double = .0
  var transit: Boolean = false
  var station: Station = null


  def weight: Int = {
    cars.foldLeft(0) {
      (total, car) => total + car.carType.weight
    } + loco.locoType.weight
  }

  def addLoco(l: Locomotive) {
    loco = l
    realLength += loco.locoType.length
  }

  def removeLoco() {
    loco = null
  }

  def addCar(index: Int, car: Car) {
    cars.insert(index, car)
    realLength += car.realLength()
  }

  def addCar(car: Car) {
    cars :+ car
    realLength += car.realLength()
  }

  def addAll(index: Int, cs: Seq[Car]) {
    cars.insertAll(index, cs)
    for (c <- cs) realLength += c.realLength()
  }

  def addAll(cs: Seq[Car]) {
    cars.appendAll(cs)
    for (c <- cs) realLength += c.realLength()
  }

  def removeLocomotive(): Locomotive = {
    if (loco == null) throw new IllegalStateException("locomotive is null now")
    val l: Locomotive = loco
    realLength -= l.locoType.length
    loco = null
    l
  }

  def removeCar(index: Int): Car = {
    if (cars == null) throw new IllegalStateException("cars is null")
    val car: Car = cars.remove(index)
    realLength -= car.realLength()
    car
  }

  def removeCar(car: Car) {
    if (cars == null) throw new IllegalStateException("cars is null")
    cars -= car
    realLength -= car.realLength()

  }

  def removeAll(cs: Seq[Car]) {
    if (cars == null) throw new IllegalStateException("cars is null")
    for (car <- cs) {
      realLength -= car.realLength()
      cars -= car
    }

  }

  override def get(i: Int): Car = {
    if (cars == null) throw new IllegalStateException("cars is null")
    cars.apply(i)
  }

  override def getFirst: RailCar = {
    if (cars == null) throw new IllegalStateException("cars is null")
    cars.head
  }

  override def getLast: RailCar = {
    if (cars == null) throw new IllegalStateException("cars is null")
    cars.last
  }

  override def getHead: RailCar = {
    if (cars == null) throw new IllegalStateException("cars is null")
    if (!isMoving) return null
    if (getDirection) getFirst else getLast
  }

  override def getTail: RailCar = {
    if (cars == null) throw new IllegalStateException("cars is null")
    if (!isMoving) return null
    if (!getDirection) getFirst else getLast
  }

  override def size: Int = {
    if (cars == null) throw new IllegalStateException("cars is null")
    cars.size
  }
}