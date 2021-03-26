fun main() {
    val m1 = Matrix(2, 3) { _, _ -> 0}
    m1[0, 0] = 1
    m1[0, 1] = 2
    m1[0, 2] = 3
    m1[1, 0] = 4
    m1[1, 1] = 5
    m1[1, 2] = 6
    val m2 = Matrix(3, 3) { _, _ -> 3}
    println(m1)
    println(m2)
    println(m1.transponir())
    println(m2 + m2)
    println(m1 * m2)
    println(m1.determinant())
    println()

    val m3 = Matrix(2, 3) { _, _ -> ComplexNumber(1.0, 4.0)}
    val m4 = Matrix(3, 3) { _, _ -> ComplexNumber(2.0, 22.0)}
    m3[0, 0] = ComplexNumber(1.0, 0.0)
    m3[0, 1] = ComplexNumber(2.0, 0.0)
    m3[0, 2] = ComplexNumber(3.0, 0.0)
    m3[1, 0] = ComplexNumber(4.0, 0.0)
    m3[1, 1] = ComplexNumber(5.0, 0.0)
    m3[1, 2] = ComplexNumber(6.0, 0.0)
    println(m4 + m4)
    println(m3 * m4)
    println(m3.determinant())
    println()
}
