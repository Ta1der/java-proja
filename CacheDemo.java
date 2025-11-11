
public class CacheDemo {
    public static void main(String[] args) {
        Cache<Integer> cache = new Cache<>(3);
        
        System.out.println("Добавляем элементы 1, 2, 3:");
        cache.add(1);
        cache.add(2);
        cache.add(3);
        System.out.println("Размер: " + cache.size());
        System.out.println("Первый: " + cache.getFirst());
        System.out.println("Последний: " + cache.getLast());
        
        System.out.println("\nДобавляем элемент 4 (должен вытеснить 1):");
        cache.add(4);
        System.out.println("Размер: " + cache.size());
        System.out.println("Первый: " + cache.getFirst());
        System.out.println("Последний: " + cache.getLast());
        
        System.out.println("\nПроверка существования:");
        System.out.println("Есть ли 2: " + cache.exists(2));
        System.out.println("Есть ли 1: " + cache.exists(1));
        
        System.out.println("\nПолучение по индексу:");
        for (int i = 0; i < cache.size(); i++) {
            System.out.println("Индекс " + i + ": " + cache.getItemByIndex(i));
        }
        
        System.out.println("\nУдаление элемента 2:");
        System.out.println("Удален: " + cache.remove(2));
        System.out.println("Размер после удаления: " + cache.size());
    }
}