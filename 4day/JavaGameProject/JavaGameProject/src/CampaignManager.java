public class CampaignManager implements CampaignService {

    @Override
    public void add(Campaign campaign) {
        // TODO Auto-generated method stub
        System.out.println(campaign.getCampaignName() + " Adli Kampanya Eklendi => " + campaign.getCampaignDiscount() + "% indirim");
    }

    @Override
    public void update(Campaign campaign) {
        // TODO Auto-generated method stub
        System.out.println(campaign.getCampaignName() + " Adli Kampanya Güncellendi => Yeni Kampanya => " + campaign.getCampaignDiscount()
                + "% indirim");
    }

    @Override
    public void delete(Campaign campaign) {
        // TODO Auto-generated method stub
        System.out.println(campaign.getCampaignName() + " Adli Kampanya Silindi => " + campaign.getCampaignId());
    }

}