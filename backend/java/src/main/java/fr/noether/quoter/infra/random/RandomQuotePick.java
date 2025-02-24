package fr.noether.quoter.infra.random;

import fr.noether.quoter.core.repository.RandomPicker;

import java.util.Random;

public class RandomQuotePick implements RandomPicker {
    @Override
    public int nextInt(int min, int maxExcluded) {
        Random random = new Random();
        return random.nextInt(min, maxExcluded);
    }
}
