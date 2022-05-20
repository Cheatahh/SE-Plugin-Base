import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.geometry.Point
import kotlin.math.abs
import kotlin.math.sqrt

infix operator fun Point.rangeTo(other: Point) : Double {

    val dx = abs(x - other.x)
    val dy = abs(y - other.y)

    return sqrt((dx * dx + dy * dy).toDouble())
}