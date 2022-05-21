@file:Suppress("NOTHING_TO_INLINE")

import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.geometry.Point
import java.awt.geom.Point2D
import kotlin.math.abs
import kotlin.math.sqrt

inline infix operator fun Point.rangeTo(other: Point) = Point2D.distance(x.toDouble(), y.toDouble(), other.x.toDouble(), other.y.toDouble())