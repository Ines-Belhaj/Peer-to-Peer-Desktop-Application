package peer_to_peer.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import peer_to_peer.model.Student;

public class AvailabilityDao implements Dao<Availability> {
	
		
		 private List<Availability> availabilities = new ArrayList<>();

		@Override
		public Availability get(int index) {
			return availabilities.get(index);
		}

		@Override
		public List<Availability> getAll() {
			return availabilities;
		}

		@Override
		public void save(Availability availability) {
			availabilities.add(student);
		}

		@Override
		public void update(int index, Availability availability) {
			availabilities.set(index, student);
		}

		@Override
		public void delete(Availability availability) {
			availabilities.remove(student);
			
		}
}
