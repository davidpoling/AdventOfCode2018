package advent.code;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day1 extends AdventCode2018 {

    private List<Integer> entities;

    public Day1() {
        this(PREFIX + "frequency.txt");
    }

    protected Day1(String filePath) {
        super(filePath);
        this.entities = new ArrayList<>();
    }

    @Override
    public List<Integer> readEntities() throws IOException {
        Files.lines(FileSystems.getDefault().getPath(this.filePath)).forEach(line -> {
            int val = 0;
            if (line.contains("+")) {
                line = line.substring(1);
                val = Integer.parseInt(line);
            } else if (line.contains("-")) {
                line = line.substring(1);
                val = 0 - Integer.parseInt(line);
            }
            this.entities.add(val);
        });

        return this.entities;
    }

    @Override
    public int dayOnePart1() throws IOException {
        this.entities = this.readEntities();
        return this.entities
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public int dayOnePart2() {
        int result = 0;
        Set<Integer> seen = new HashSet<>();

        while (true) {
            for (Integer each : this.entities) {
                result += each;
                if (!seen.add(result)) {
                    return result;
                }
            }
        }
    }
}
