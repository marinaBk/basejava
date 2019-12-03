import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
   private  Resume[] storage = new Resume[10000];
   private int _size = 0;

    void clear() {
        for (int i = 0; i < _size; i++) {
                storage[i] = null;
        }
        _size=0;
    }

    void save(Resume r) {
        if (r != null) {
            storage[_size] = new Resume();
            storage[_size].uuid = r.uuid;
            _size++;
        }
    }

    Resume get(String uuid) {
        Resume emptyR = null;

        if (uuid != null) {
            for (int i = 0; i < _size; i++) {
                if (uuid.equals(storage[i].uuid)) {
                    return storage[i];
                }
            }
            emptyR = new Resume();
            emptyR.uuid = uuid.concat(" is absent!");
        }

        return emptyR; //or return null;
    }

    void delete(String uuid) {
   if (uuid !=null)
        for (int i = 0; i < _size ; i++) {
            if(uuid.equals(storage[i].uuid)) {
                for (int j = i; j < _size; j++) {
                    if (j==_size-1)
                        storage[j] = null;
                    else
                        storage[j] = storage[j+1];
                }
                _size--;
               break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
     Resume[] newArray = new Resume[_size];
        System.arraycopy(storage, 0, newArray , 0, _size);
        return newArray;
    }

    int size() {
        return _size;
    }
}
