import kotlin.math.cos
import kotlin.math.sqrt

data class ComplexNumber(private var a: Double = 0.0, private var b: Double = 0.0) {

    fun getA(): Double {
        return this.a
    }

    fun getB(): Double {
        return this.b
    }

    fun setValue(x: ComplexNumber) {
        this.a = x.getA()
        this.b = x.getB()
    }

    operator fun plus(other: ComplexNumber): ComplexNumber = ComplexNumber(a + other.a, b + other.b)

    operator fun minus(other: ComplexNumber): ComplexNumber = ComplexNumber(a - other.a, b - other.b)

    operator fun times(other: ComplexNumber): ComplexNumber = ComplexNumber(a * other.a - b * other.b, a * other.b + b * other.a)

    fun abs(): Double {
        return sqrt(this.a * this.a + this.b * this.b)
    }

    fun printTrigon(): String {
        val z = abs()
        return "z=|" + z + "| * (cos(" + cos(a / z) + ") + sin(" + Math.sin(b / z) + ")"
    }

    override fun toString(): String {
        return if (b != 0.0) a.toString() + "+" + b + "i" else a.toString() + ""
    }
}