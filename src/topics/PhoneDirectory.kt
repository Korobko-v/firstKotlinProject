package topics

//John keeps a backup of his old personal phone book as a text file. On each line of the file he can find the phone number (formated as +X-abc-def-ghij where X stands for one or two digits), the corresponding name between < and > and the address.
//
//Unfortunately everything is mixed, things are not always in the same order; parts of lines are cluttered with non-alpha-numeric characters (except inside phone number and name).
//
//Examples of John's phone book lines:
//
//"/+1-541-754-3010 156 Alphand_St. <J Steeve>\n"
//
//" 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010!\n"
//
//"<Anastasia> +48-421-674-8974 Via Quirinal Roma\n"
//
//Could you help John with a program that, given the lines of his phone book and a phone number num returns a string for this number : "Phone => num, Name => name, Address => adress"

object PhoneDir {


    fun phone(strng: String, num: String): String {
        //split string into lines
        val lines = strng.split("\n")

        var currentLine = ""
        var count = 0

        var name = ""

        //find a line with the given number in
        for (s in lines) {
            //check if the line contains the given number, and it's not the part of another number
            if (s.contains("(^|\\D)$num(\\D|$)".toRegex())) {
                count ++
                if (count > 1
                    && !s.substring(s.indexOf('<') + 1, s.indexOf('>')).equals(name)) return "Error => Too many people: $num"
                currentLine = s
                name = s.substring(currentLine.indexOf('<') + 1, s.indexOf('>'))
            }
        }

        if (count == 0) return "Error => Not found: $num"

        val address = currentLine
            .replace(name, "")
            .replace(num, "")
            .replace("[[^\\d\\w\\s-.]_]".toRegex(), " ")
            .replace("( )+".toRegex(), " ")
            .trim()

        return "Phone => $num, Name => $name, Address => $address"
    }
}