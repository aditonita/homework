package com.ibm.streams;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.omg.Messaging.SyncScopeHelper;

public class Streams {

	public static class NotImplementedException extends RuntimeException {
		public NotImplementedException() {
			super("This method hasn't been implemented yet!");
		}
	}

	public static List<Integer> returnSquareRoot(List<Integer> numbers) {
		List<Integer> ls = numbers.stream().map(n -> (int) Math.sqrt((double) n)).collect(Collectors.toList());
		return ls;
	}

	public static List<Integer> getAgeFromUsers(List<User> user) {
		List<Integer> ls = user.stream().map(u -> u.getAge()).collect(Collectors.toList());
		return ls;
	}

	public static List<Integer> getDistinctAges(List<User> users) {
//		Set<Integer> si = users.stream().map(u -> u.getAge()).collect(Collectors.toSet());
//		List<Integer> li = new ArrayList<>();
//		si.forEach(e -> li.add(e));
		List<Integer> li = users.stream().map(u -> u.getAge()).distinct().collect(Collectors.toList());
		return li;
	}

	public static List<User> getLimitedUserList(List<User> users, int limit) {
		List<User> lu = users.stream().limit(limit).collect(Collectors.toList());
		return lu;
	}

	public static Integer countUsersOlderThen25(List<User> users) {
		return (int) users.stream().map(u -> u.getAge()).filter(age -> (age > 25)).count();
	}

	public static List<String> mapToUpperCase(List<String> strings) {
		List<String> ls = strings.stream().map(e -> e.toUpperCase()).collect(Collectors.toList());
		return ls;
	}

	public static Integer sum(List<Integer> integers) {
		return (integers.stream().collect(Collectors.summingInt(Integer::new)));
	}

	public static List<Integer> skip(List<Integer> integers, Integer toSkip) {
		List<Integer> li = integers.stream().skip(toSkip).collect(Collectors.toList());
		return li;
	}

	public static List<String> getFirstNames(List<String> names) {
		List<String> ls = names.stream().map(e -> e.split(" ")[0]).collect(Collectors.toList());
		return ls;
	}

	public static List<String> getDistinctLetters(List<String> names) {
		List<String> ls = names.stream().flatMap(n -> Stream.of(n.split(""))).distinct().collect(Collectors.toList());
		return ls;
	}

	public static String separateNamesByComma(List<User> users) {
		String s = users.stream().map(n -> n.getName()).collect(Collectors.joining(", "));
		return s;
	}

	public static double getAverageAge(List<User> users) {
		double d;
		d = users.stream().map(u -> u.getAge()).collect(Collectors.averagingDouble(Double::new));
		return d;
	}

	public static Integer getMaxAge(List<User> users) {
		Integer n = users.stream().map(u -> u.getAge()).max((x, y) -> Integer.compare(x, y)).orElse(Integer.MIN_VALUE);
		return n;
	}

	public static Integer getMinAge(List<User> users) {
		Integer n = users.stream().map(u -> u.getAge()).min((x, y) -> Integer.compare(x, y)).orElse(Integer.MAX_VALUE);
		return n;
	}

	public static Map<Boolean, List<User>> partionUsersByGender(List<User> users) {
		Map<Boolean, List<User>> map = users.stream().collect(Collectors.partitioningBy(user -> user.isMale()));
		return map;
	}

	public static Map<Integer, List<User>> groupByAge(List<User> users) {
		Map<Integer, List<User>> map = users.stream().collect(Collectors.groupingBy(user -> user.getAge()));
		return map;
	}

	public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users) {
		Map<Boolean, Map<Integer, List<User>>> map;
//		System.out.println(users.stream().collect(Collectors.groupingBy(u->u.getAge(),Collectors.partitioningBy(u -> u.isMale()))));
//		System.out.println(users.stream().collect(Collectors.partitioningBy(u->u.isMale(),Collectors.groupingBy(u -> u.getAge()))));
		map = users.stream()
				.collect(Collectors.partitioningBy(u -> u.isMale(), Collectors.groupingBy(u -> u.getAge())));
		return map;
	}

	public static Map<Boolean, Long> countGender(List<User> users) {
		Map<Boolean, Long> map;
		map = users.stream().collect(Collectors.partitioningBy(u -> u.isMale(), Collectors.counting()));
		return map;
	}

	public static boolean anyMatch(List<User> users, int age) {
		return users.stream().anyMatch(u -> u.getAge() == age);
	}

	public static boolean noneMatch(List<User> users, int age) {
		return users.stream().noneMatch(u -> u.getAge() == age);
	}

	public static Optional<User> findAny(List<User> users, String name) {
		return users.stream().findAny().filter(user -> user.getName().equals(name));
	}

	public static List<User> sortByAge(List<User> users) {
		Comparator<User> comp = new Comparator<User>() {
			@Override
			public int compare(User arg0, User arg1) {
				return arg0.getAge() - arg1.getAge();
			}
		};
		return users.stream().sorted(comp).collect(Collectors.toList());
	}

	public static Stream<Integer> getBoxedStream(IntStream stream) {
//		return stream.map(e -> (Integer)e).boxed();
		return stream.boxed();
	}

	public static List<Integer> generateFirst10PrimeNumbers() {
//		List<Integer> listPrim = Stream.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29).collect(Collectors.toList());
		List<Integer> listPrim = Stream.iterate(2, n -> {
			while (true) {
				n++;
				boolean prim = true;
				for (int i = 2; i < n; i++) {
					if ((n % i) == 0) {
						prim = false;
						break;
					}
				}
				if (prim) {
					return n;
				}
			}
		}).limit(10).collect(Collectors.toList());
		return listPrim;
	}

	public static boolean isPrime(int number) {
		return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
	}

	public static List<Integer> generate10RandomNumbers() {
		List<Double> ld = Stream.generate(Math::random).limit(10).collect(Collectors.toList());
		List<Integer> li = new ArrayList<>();
		
		ld.forEach(e -> li.add((int)((double)(e*100))));
		return li;
	}

	public static User findOldest(List<User> users) {
//		Comparator<User> comparator = new Comparator<User>() {
//			@Override
//			public int compare(User arg0, User arg1) {
//				return arg0.getAge() + arg1.getAge();
//			}
//		};
//		return users.stream().max(comparator).get();
		return users.stream().max((u1, u2) -> u1.getAge() - u2.getAge()).get();
	}

	public static int sumAge(List<User> users) {
		return users.stream().mapToInt(u -> u.getAge()).sum();
	}

}
