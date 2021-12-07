package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.model.RacingCars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceService {
    private Race race;

    public RacingCars createRacingCars(String[] name) {
        List<Car> racingCars = Arrays.stream(name).map(Car::new).collect(Collectors.toList());
        return new RacingCars(racingCars);
    }

    public void createRace(int numberOfRaces, RacingCars racingCars) {
        this.race = new Race(numberOfRaces, racingCars);
    }

    public void repeatRace() {
        for (int i=0; i<race.getNumberOfRaces(); i++) {
            RacingCars racingCars = race.getRacingCars();
            racingCars.moveForwardOrStop();
            racingCars.getRacingCarsInfo();
            System.out.println();
        }
    }
}
