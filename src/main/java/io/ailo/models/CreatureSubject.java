package io.ailo.models;

public interface CreatureSubject {
    public void registerObserver(CreatureObserver o);
    public void notifyObservers();
}
