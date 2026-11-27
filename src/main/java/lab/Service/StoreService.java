package lab.Service;

import lab.Model.Store;
import lab.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    // Save a store
    public Store persistStore(Store store) {
        return storeRepository.save(store);
    }

    // Get all stores
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    // Get store by ID
    public Store getStoreById(long id) {
        return storeRepository.findById(id).orElse(null);
    }

    // Delete store by ID
    public void deleteStore(long id) {
        storeRepository.deleteById(id);
    }

    // Update store
    public Store updateStore(long id, Store replacement) {
        Store existingStore = storeRepository.findById(id).orElse(null);

        if (existingStore == null) {
            return null;
        }

        replacement.setId(id);
        return storeRepository.save(replacement);
    }
}