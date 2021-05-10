package Kamil.Bookstore.Services;

import Kamil.Bookstore.Model.Addres;
import Kamil.Bookstore.Repository.AddresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddresService {
    private final AddresRepository addresRepository;

    public AddresService(AddresRepository addresRepository) {
        this.addresRepository = addresRepository;
    }

    public List<Addres> getAll(){
        return addresRepository.findAll();
    }

    public Addres findById(Long id){
        return addresRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public Addres addAddres(Addres addres){
        return addresRepository.save(addres);
    }

    public Addres updateAddres(Long id, Addres updatedAddress){
        updatedAddress.setId(id);
        return addresRepository.save(updatedAddress);
    }

    public void deleteAddres(Long id){
        addresRepository.deleteById(id);
    }




}
