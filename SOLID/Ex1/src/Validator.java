import java.util.ArrayList;
import java.util.List;

public class Validator {
    public List<String> validate(ParsedInput in) {
        List<String> errors = new ArrayList<>();
        if (in.name == null || in.name.trim().isEmpty()) errors.add("name is required");
        if (in.email == null || in.email.trim().isEmpty() || !in.email.contains("@")) errors.add("email is invalid");
        if (in.phone == null || in.phone.trim().isEmpty() || !in.phone.chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        if (!("CSE".equals(in.program) || "AI".equals(in.program) || "SWE".equals(in.program))) errors.add("program is invalid");
        return errors;
    }
}
