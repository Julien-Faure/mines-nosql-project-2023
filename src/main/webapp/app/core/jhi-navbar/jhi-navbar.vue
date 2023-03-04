<template>
  <b-navbar data-cy="navbar" toggleable="md" type="light" class="bg-light">
    <b-navbar-brand class="logo" b-link to="/">
      <span class="logo-img"></span>
      <span class="navbar-title">projet_nosql</span> <span class="navbar-version">{{ version }}</span>
    </b-navbar-brand>
    <b-navbar-toggle
      right
      class="jh-navbar-toggler d-lg-none"
      href="javascript:void(0);"
      data-toggle="collapse"
      target="header-tabs"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <font-awesome-icon icon="bars" />
    </b-navbar-toggle>

    <b-collapse is-nav id="header-tabs">
      <b-navbar-nav class="ml-auto">
        <b-nav-item to="/" exact>
          <span>
            <font-awesome-icon icon="home" />
            <span>Home</span>
          </span>
        </b-nav-item>
        <b-nav-item-dropdown right active-class="active" class="pointer" data-cy="entity">
          <span slot="button-content" class="navbar-dropdown-menu">
            <font-awesome-icon icon="th-list" />
            <span class="no-bold">Database</span>
          </span>
          <entities-menu></entities-menu>
          <!-- jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here -->
          <b-dropdown-item to="/database/injection" active-class="active">
            <font-awesome-icon icon="users" />
            <span>Person list</span>
          </b-dropdown-item>

          <b-dropdown-item to="/database/request/1" active-class="active">
            <font-awesome-icon icon="users" />
            <span>Requete 1</span>
          </b-dropdown-item>

          <b-dropdown-item to="/database/request/2" active-class="active">
            <font-awesome-icon icon="users" />
            <span>Requete 2</span>
          </b-dropdown-item>

          <b-dropdown-item to="/database/request/3" active-class="active">
            <font-awesome-icon icon="users" />
            <span>Requete 3</span>
          </b-dropdown-item>

        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</template>

<script lang="ts" src="./jhi-navbar.component.ts"></script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
/* ==========================================================================
    Navbar
    ========================================================================== */
.navbar-version {
  font-size: 10px;
}

@media screen and (min-width: 768px) {
  .jh-navbar-toggler {
    display: none;
  }
}

@media screen and (min-width: 768px) and (max-width: 1150px) {
  span span {
    display: none;
  }
}

.navbar-title {
  display: inline-block;
  vertical-align: middle;
}

/* ==========================================================================
    Logo styles
     ========================================================================== */
.navbar-brand.logo {
  padding: 5px 15px;
}

.logo .logo-img {
  height: 45px;
  display: inline-block;
  vertical-align: middle;
  width: 70px;
}

.logo-img {
  height: 100%;
  background: url('../../../content/images/logo-jhipster.png') no-repeat center center;
  background-size: contain;
  width: 100%;
  filter: drop-shadow(0 0 0.05rem white);
}
</style>
