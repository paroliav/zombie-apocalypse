package io.ailo.models;

import java.util.List;

public interface ZombieSubject {
    public void registerMoveObserver(List<ZombieMoveObserver> o);
    public void registerWalkObserver(ZombieWalkObserver o);
    public void notifyMoveObservers();
    public void notifyWalkObservers(Grid grid);
}
