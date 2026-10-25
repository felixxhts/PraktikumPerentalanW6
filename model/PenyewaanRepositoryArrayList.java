package model;

import java.util.ArrayList;
import java.util.List;

public class PenyewaanRepositoryArrayList implements PenyewaanRepository {
    private final List<Penyewaan> data = new ArrayList<>();

    @Override
    public String buatIdBaru() {
        return String.format("SW-%03d", data.size() + 1);
    }

    @Override
    public void tambah(Penyewaan penyewaan) {
        data.add(penyewaan);
    }

    @Override
    public List<Penyewaan> semua() {
        return new ArrayList<>(data);
    }

    @Override
    public Penyewaan cariAktifByPlat(String platNomor) {
        for (Penyewaan penyewaan : data) {
            if (penyewaan.isAktif() && penyewaan.getKendaraan().getPlatNomor().equalsIgnoreCase(platNomor)) {
                return penyewaan;
            }
        }
        return null;
    }
}