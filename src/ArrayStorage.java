import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        if (r != null) {
            storage[size] = new Resume();
            storage[size].uuid = r.uuid;
            size++;
        }
    }

    Resume get(String uuid) {
        // Resume emptyR = null;
        if (uuid != null) {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].uuid)) {
                    return storage[i];
                }
            }
            //    emptyR = new Resume();
            //    emptyR.uuid = uuid.concat(" is absent!");
        }
        //return emptyR; //or
        return null;
    }

    void delete(String uuid) {
        if (uuid != null) {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].uuid)) {
                    for (int j = i; j < size; j++) {
                        if (j == size - 1)
                            storage[j] = null;
                        else
                            storage[j] = storage[j + 1];
                    }
                    size--;
                    break;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        System.arraycopy(storage, 0, resumes, 0, size);
        return resumes;
    }

    int size() {
        return size;
    }
}
