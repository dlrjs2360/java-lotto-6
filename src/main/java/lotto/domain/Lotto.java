package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.CommonLetter;
import lotto.validator.impl.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        validate(numbers);
        this.numbers = toNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validate(String numbers) {
        new LottoValidator().validate(numbers);
    }

    public void print() {
        System.out.println(numbers);
    }

    List<Integer> toNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(CommonLetter.SEPARATOR.getLetter()))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
