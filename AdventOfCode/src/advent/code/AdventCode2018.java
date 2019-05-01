package advent.code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AdventCode2018 {

    protected String filePath;
    protected static final String PREFIX = "src/advent/code/";

    protected AdventCode2018(final String filePath) {
        this.filePath = filePath;
    }

    public List<?> readEntities() throws IOException {
        return new ArrayList<>();
    }

    public int dayOnePart1() throws IOException {
        return 0;
    }

    public int dayOnePart2() {
        return 0;
    }

    public int dayTwoPart1() throws IOException {
        return 0;
    }

    public String dayTwoPart2() {
        return "";
    }
}
