package BiXiangDong.Reflect_Learning;

public class Mainboard {
    public void run() {
        System.out.println("Main board run......");
    }

    public void PCI(PCI pci) {//  PCI p = new SoundCard
        if (pci != null) {
            pci.open();
            pci.close();
        }
    }
}
