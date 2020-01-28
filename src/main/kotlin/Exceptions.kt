import java.lang.Exception

class IncorrectArguments(expectedArgs: List<String>) : Exception("Expected arguments: ${expectedArgs.joinToString()}") {
    constructor(expectedArg: String) : this(listOf(expectedArg))
}
