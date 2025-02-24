package fr.noether.quoter.core.mock;

import fr.noether.quoter.core.repository.RandomPicker;

public record FakeRandom(int value) implements RandomPicker {
    @Override
    public int nextInt(int min, int maxExcluded) {
        return this.value;
    }
}
