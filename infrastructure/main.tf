locals {
  tags = (merge(
    var.common_tags,
    tomap({
      "Team Contact" = var.team_contact
      "Destroy Me"   = var.destroy_me
    })
  ))
}

provider "azurerm" {
  features {}
}

resource "azurerm_resource_group" "rg" {
  name     = "${var.product}-shared-${var.env}"
  location = var.location
}
