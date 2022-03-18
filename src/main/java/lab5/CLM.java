/*
package lab5;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.Hashtable;

public class CollectionManager {
        @Getter
        private final TimedCollection<Hashtable<String, Vehicle>> hashtable = new TimedCollection<>(new Hashtable<>());
        private final PrintInformation printInformation = new PrintInformation(System.out);
        private final UserInput userInput = new UserInput();
        private final WriteIntoFile writeIntoFile = new WriteIntoFile();
        private final Hashtable<String, Vehicle> copyOfCollection = new Hashtable<>();


        public CollectionManager(Map<String, Vehicle> loadedCollection) {
            for (String key : loadedCollection.keySet()
            ) {
                hashtable.getCollection().put(key, loadedCollection.get(key));
            }
        }


        public String prepareCollectionToOutput() {
            StringBuilder stringFormatOfCollection = new StringBuilder();
            var collection = this.hashtable.getCollection();
            for (String key : collection.keySet()
            ) {
                stringFormatOfCollection.append(collection.get(key)).append("\n");
            }
            return stringFormatOfCollection.toString();
        }

        private Vehicle createNewVehicle(String message) {
            printInformation.printInStream(message);

            boolean fUserInputAllValue = false;

            var newBuiderOfObject = Vehicle.builder();
            Vehicle newObject = null;

            newBuiderOfObject.id((long) ((int) (Math.random() * 1000)));
            newBuiderOfObject.creationDate(LocalDateTime.now());
            while (!fUserInputAllValue) {

                var nameOfObject = userInput.getString("Введите имя объекта");
                newBuiderOfObject.name(nameOfObject);
                System.out.println("ееей + " + nameOfObject);
                int x = userInput.getInt("Введите координату X (int) :");
                int y = userInput.getInt("Введите координату Y (int) :");
                newBuiderOfObject.coordinates(new Coordinates(x, y));
                int enginePower = userInput.getInt("Введите engine power(int) :");
                newBuiderOfObject.enginePower(enginePower);
                int numberOfWheels = userInput.getInt("Введите количество колес (не наркотики) (int) :");
                newBuiderOfObject.numberOfWheels(numberOfWheels);
                VehicleType vehicleType = userInput.getVehicleEnum("Введите тип транспортного средства");
                newBuiderOfObject.type(vehicleType);
                FuelType fuelType = userInput.getFuelType("Введите тип топлива");
                newBuiderOfObject.fuelType(fuelType);
                newObject = newBuiderOfObject.build();
                System.out.println(newObject);
                fUserInputAllValue = true;
            }
            return newObject;
        }


        //    Команды
        public void showElements() {
            for (String key : hashtable.getCollection().keySet()
            ) {
                System.out.println(hashtable.getCollection().get(key) + "\n");
            }
        }

        //    Help
        public void help() {
            System.out.println(
                    "Команда то то"
            );
            System.out.println(prepareCollectionToOutput());

        }

        //    Info
        public void info() {
            String[] listik = hashtable.getClass().getName().split("\\.");
            System.out.println("Collection information:\n" +
                    "Type: " + listik[listik.length - 1] + ".\n" +
                    "Initialize date: " + hashtable.getInitializationTime() + ".\n" +
                    "Element count: " + hashtable.getCollection().size());
        }
        //    Show
        public void show() {
            hashtable.getCollection().values().stream().sorted().forEach(System.out::println);
//        for (String key : hashtable.getCollection().keySet()
//        ) {
//            System.out.println(key + " " + hashtable.getCollection().get(key));
//        }
        }

        //    Insert
        public void insert(String key) {
            hashtable.getCollection().put(key, createNewVehicle("Идет создание объекта!"));
        }

        //   Update
        public void update(String id) {
            Vehicle newObject = createNewVehicle("Идет обновление элемента!");

//        Находим элемент коллекции, id которого равен параметру
            boolean objectWasFinded = false;
            String keyOfThisObj = null;
            Vehicle thisObj = null;
            for (String key : hashtable.getCollection().keySet()
            ) {
                if (!objectWasFinded) {
                    var iterableObj = hashtable.getCollection().get(key);
                    if (iterableObj.getId() == Long.parseLong(id)) {
                        printInformation.printInStream("Вы обновили элемент! ");
                        objectWasFinded = true;
                        keyOfThisObj = key;
                    }
                } else break;
            }
            if (objectWasFinded) hashtable.getCollection().replace(keyOfThisObj, thisObj, newObject);
            else {
                printInformation.printInStream("Элемента с таким ID не найдено");
            }
        }

        //    Remove
        public void remove_key(String key) {
            hashtable.getCollection().remove(key);
        }

        //  Clear
        public void clear() {
            hashtable.getCollection().clear();
        }

        //    Save
        public void save() {
            writeIntoFile.saveCollectionInFile(this);
        }

//    Exsecute?


        //    remove_greater
        public void removeGreater() {
            var createdElement = createNewVehicle("Укажите элемент !: ");
            copyOfCollection.putAll(hashtable.getCollection());
            System.out.println("але" + copyOfCollection);
            copyOfCollection.forEach((key, obj) -> {
                if (createdElement.compareTo(obj) < 0) {
                    System.out.println(createdElement + " меньше " + obj);
                    hashtable.getCollection().remove(key);
                }else {
                    System.out.println("ыы");
                }
            });
        }

        //    remove_lower
        public void removeLower() {
            var createdElement = createNewVehicle("Укажите элемент !: ");
            copyOfCollection.forEach((key, obj) -> {
                if (createdElement.compareTo(obj) > 0) hashtable.getCollection().remove(key);
            });
        }

        //    replace_if_greater
        public void replace_if_greater(String key){

        }


        //    sum_of_engine_power
        public void sumOfEnginePower() {
            int sumOfEnginePower = 0;
            for (String key : hashtable.getCollection().keySet()
            ) {
                sumOfEnginePower += hashtable.getCollection().get(key).getEnginePower();
            }
            printInformation.printInStream("Сумма значений поля EnginePower:  " + String.valueOf(sumOfEnginePower));
        }

        //    filter_contains_name
        public void filterContainsName(String name) {
            for (String key : hashtable.getCollection().keySet()
            ) {
                if (hashtable.getCollection().get(key).getName().contains(name)) {
                    printInformation.printInStream(String.valueOf(hashtable.getCollection().get(key)));
                }
            }
        }

        //    print_field_descending_fuel_type
        public void printFieldDescendingFuelType() {
//        var newSortedCollection =
//        hashtable.getCollection().e
//        hashtable.getCollection().entrySet().stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
            hashtable.getCollection().values().stream().sorted(Comparator.comparing(Vehicle::getFuelType)).forEach((obj) -> printInformation.printInStream(String.valueOf(obj)));
        }
    }
}
*/
